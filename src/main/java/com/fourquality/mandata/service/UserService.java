package com.fourquality.mandata.service;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.Authority;
import com.fourquality.mandata.domain.User;
import com.fourquality.mandata.repository.AuthorityRepository;
import com.fourquality.mandata.repository.UserRepository;
import com.fourquality.mandata.security.AuthoritiesConstants;
import com.fourquality.mandata.security.SecurityUtils;
import com.fourquality.mandata.service.dto.UserDTO;
import com.fourquality.mandata.service.dto.UserManagementDTO;
import com.fourquality.mandata.service.util.RandomUtil;
import com.fourquality.mandata.web.rest.errors.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    private final CacheManager cacheManager;

    public UserService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        AuthorityRepository authorityRepository,
        CacheManager cacheManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.cacheManager = cacheManager;
    }

    public Optional<User> activateRegistration(String key) {
        log.debug("Activating user for activation key {}", key);
        return userRepository.findOneByActivationKey(key)
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                user.setActivationKey(null);
                this.clearUserCaches(user);
                log.debug("Activated user: {}", user);
                return user;
            });
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
        log.debug("Reset user password for reset key {}", key);
        return userRepository.findOneByResetKey(key)
            .filter(user -> user.getResetDate().isAfter(Instant.now().minusSeconds(86400)))
            .map(user -> {
                user.setPassword(passwordEncoder.encode(newPassword));
                user.setResetKey(null);
                user.setResetDate(null);
                this.clearUserCaches(user);
                return user;
            });
    }

    public Optional<User> requestPasswordReset(String mail) {
        return userRepository.findOneByEmailIgnoreCase(mail)
            .filter(User::getActivated)
            .map(user -> {
                user.setResetKey(RandomUtil.generateResetKey());
                user.setResetDate(Instant.now());
                this.clearUserCaches(user);
                return user;
            });
    }

    public User registerUser(UserDTO userDTO, String password) {
        userRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).ifPresent(existingUser -> {
            boolean removed = removeNonActivatedUser(existingUser);
            if (!removed) {
                throw new LoginAlreadyUsedException();
            }
        });
        userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).ifPresent(existingUser -> {
            boolean removed = removeNonActivatedUser(existingUser);
            if (!removed) {
                throw new EmailAlreadyUsedException();
            }
        });
        User newUser = new User();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(userDTO.getLogin().toLowerCase());
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail().toLowerCase());
        newUser.setImageUrl(userDTO.getImageUrl());
        newUser.setLangKey(userDTO.getLangKey());
        // new user is not active
        newUser.setActivated(false);
        // new user gets registration key
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        this.clearUserCaches(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    private boolean removeNonActivatedUser(User existingUser){
        if (existingUser.getActivated()) {
             return false;
        }
        userRepository.delete(existingUser);
        userRepository.flush();
        this.clearUserCaches(existingUser);
        return true;
    }

    /*-----------------------------USER---------------------------------*/
    public User createUser(UserManagementDTO userManagementDTO) {
        User user = new User();
        user.setLogin(userManagementDTO.getLogin().toLowerCase());
        user.setName(userManagementDTO.getName());
        user.setEmail(userManagementDTO.getEmail().toLowerCase());
        user.setImageUrl(userManagementDTO.getImageUrl());
        if (userManagementDTO.getLangKey() == null) {
            user.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
        } else {
            user.setLangKey(userManagementDTO.getLangKey());
        }

        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);

        if (Objects.isNull(userManagementDTO.getAuthorities())) {
            userManagementDTO.setAuthorities(new HashSet<>());
            userManagementDTO.getAuthorities().add(AuthoritiesConstants.USER);
        }

        user.setCnpj(userManagementDTO.getCnpj());
        user.setCpf(userManagementDTO.getCpf());
        user.setLogradouro(userManagementDTO.getLogradouro());
        user.setNumero(userManagementDTO.getNumero());
        user.setComplemento(userManagementDTO.getComplemento());
        user.setBairro(userManagementDTO.getBairro());
        user.setCidade(userManagementDTO.getCidade());
        user.setUf(userManagementDTO.getUf());
        user.setCep(userManagementDTO.getCep());
        user.setFoneFixo(userManagementDTO.getFoneFixo());
        user.setFoneCel(userManagementDTO.getFoneCel());
        user.setStatus(userManagementDTO.getStatus());

        if (userManagementDTO.getAuthorities() != null) {
            Set<Authority> authorities = userManagementDTO.getAuthorities().stream()
                .map(authorityRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
            user.setAuthorities(authorities);
        }
        user = userRepository.save(user);

        this.clearUserCaches(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userManagementDTO user to update
     * @return updated user
     */
    public Optional<UserManagementDTO> updateUser(UserManagementDTO userManagementDTO) {

        return Optional.of(userRepository
            .findById(userManagementDTO.getId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(user -> {
                this.clearUserCaches(user);
                user.setLogin(userManagementDTO.getLogin().toLowerCase());
                user.setName(userManagementDTO.getName());
                user.setEmail(userManagementDTO.getEmail().toLowerCase());
                user.setImageUrl(userManagementDTO.getImageUrl());
                user.setActivated(userManagementDTO.isActivated());
                user.setLangKey(userManagementDTO.getLangKey());
                Set<Authority> managedAuthorities = user.getAuthorities();
                managedAuthorities.clear();
                if (Objects.isNull(userManagementDTO.getAuthorities())) {
                    userManagementDTO.setAuthorities(new HashSet<>());
                    userManagementDTO.getAuthorities().add(AuthoritiesConstants.USER);
                }

                user.setCnpj(userManagementDTO.getCnpj());
                user.setCpf(userManagementDTO.getCpf());
                user.setLogradouro(userManagementDTO.getLogradouro());
                user.setNumero(userManagementDTO.getNumero());
                user.setComplemento(userManagementDTO.getComplemento());
                user.setBairro(userManagementDTO.getBairro());
                user.setCidade(userManagementDTO.getCidade());
                user.setUf(userManagementDTO.getUf());
                user.setCep(userManagementDTO.getCep());
                user.setFoneFixo(userManagementDTO.getFoneFixo());
                user.setFoneCel(userManagementDTO.getFoneCel());
                user.setStatus(userManagementDTO.getStatus());

                if (Objects.nonNull(userManagementDTO.getAuthorities())) {
                    userManagementDTO.getAuthorities().stream()
                        .map(authorityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(managedAuthorities::add);
                }

                this.clearUserCaches(user);
                log.debug("Changed Information for User: {}", user);
                return user;
            })
            .map(UserManagementDTO::new);
    }

    /**
     * Update basic information (name, email, language) for the current user.
     *
     * @param name first name of user
     * @param email email id of user
     * @param langKey language key
     * @param imageUrl image URL of user
     */
    public void updateUser(String name, String email, String langKey, String imageUrl) {
        SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByLogin)
            .ifPresent(user -> {
                user.setName(name);
                user.setEmail(email.toLowerCase());
                user.setLangKey(langKey);
                user.setImageUrl(imageUrl);
                this.clearUserCaches(user);
                log.debug("Changed Information for User: {}", user);
            });
    }

    public void deleteUser(String login) {
        userRepository.findOneByLogin(login).ifPresent(user -> {
            userRepository.delete(user);
            this.clearUserCaches(user);
            log.debug("Deleted User: {}", user);
        });
    }

    public void changePassword(String currentClearTextPassword, String newPassword) {
        SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByLogin)
            .ifPresent(user -> {
                String currentEncryptedPassword = user.getPassword();
                if (!passwordEncoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
                    throw new InvalidPasswordException();
                }
                String encryptedPassword = passwordEncoder.encode(newPassword);
                user.setPassword(encryptedPassword);
                this.clearUserCaches(user);
                log.debug("Changed password for User: {}", user);
            });
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
        return userRepository.findAllByLoginNot(pageable, Constants.ANONYMOUS_USER).map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<UserManagementDTO> getAllUsesPadroes(Pageable pageable) {
        return userRepository.buscarUsuariosPadroes(pageable).map(UserManagementDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<UserManagementDTO> getAllManagedUsersTipoAluno(Pageable pageable) {
        return userRepository.buscarAlunos(pageable, Constants.ANONYMOUS_USER).map(UserManagementDTO::new);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        return userRepository.findOneWithAuthoritiesByLogin(login);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(Long id) {
        return userRepository.findOneWithAuthoritiesById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByLogin);
    }

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        userRepository
            .findAllByActivatedIsFalseAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS))
            .forEach(user -> {
                log.debug("Deleting not activated user {}", user.getLogin());
                userRepository.delete(user);
                this.clearUserCaches(user);
            });
    }

    /**
     * @return a list of all the authorities
     */
    public List<String> getAuthorities() {
        return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
    }

    private void clearUserCaches(User user) {
        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_LOGIN_CACHE)).evict(user.getLogin());
        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE)).evict(user.getEmail());
    }
}
