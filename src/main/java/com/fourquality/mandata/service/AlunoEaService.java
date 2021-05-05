package com.fourquality.mandata.service;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.Authority;
import com.fourquality.mandata.domain.User;
import com.fourquality.mandata.repository.AuthorityRepository;
import com.fourquality.mandata.repository.UserRepository;
import com.fourquality.mandata.security.AuthoritiesConstants;
import com.fourquality.mandata.service.dto.AlunoEaDTO;
import com.fourquality.mandata.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlunoEaService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    private final CacheManager cacheManager;

    public AlunoEaService(
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

    /*-----------------------ALUNO_EA--------------------------*/
    public User createAlunoEa(AlunoEaDTO alunoEaDTO) {
        User user = new User();
        user.setLogin(alunoEaDTO.getLogin().toLowerCase());
        user.setName(alunoEaDTO.getName());
        user.setEmail(alunoEaDTO.getEmail().toLowerCase());
        user.setImageUrl(alunoEaDTO.getImageUrl());
        if (alunoEaDTO.getLangKey() == null) {
            user.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
        } else {
            user.setLangKey(alunoEaDTO.getLangKey());
        }
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);

        if (Objects.isNull(alunoEaDTO.getAuthorities())) {
            alunoEaDTO.setAuthorities(new HashSet<>());
            alunoEaDTO.getAuthorities().add(AuthoritiesConstants.USER);
        }

        if (alunoEaDTO.getAuthorities() != null) {
            Set<Authority> authorities = alunoEaDTO.getAuthorities().stream()
                .map(authorityRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
            user.setAuthorities(authorities);
        }
//        user.setDataNascimento(alunoEaDTO.getDataNascimento());
//        user.setSexo(alunoEaDTO.getSexo());
//        user.setEstadoCivil(alunoEaDTO.getEstadoCivil());
//        user.setCpf(alunoEaDTO.getCpf());
//        user.setNacionalidade(alunoEaDTO.getNacionalidade());
//        user.setNaturalidade(alunoEaDTO.getNaturalidade());
//        user.setNaturalidadeUf(alunoEaDTO.getNaturalidadeUf());
//        user.setGrauInstrucao(alunoEaDTO.getGrauInstrucao());
//        user.setProfissao(alunoEaDTO.getProfissao());
//        user.setTelefone(alunoEaDTO.getTelefone());
//        user.setCelular(alunoEaDTO.getCelular());
//        user.setLicencaCapacitacao(alunoEaDTO.getLicencaCapacitacao());
//        user.setCorRaca(alunoEaDTO.getCorRaca());
//        user.setCep(alunoEaDTO.getCep());
//        user.setEnderecoLogradouro(alunoEaDTO.getEnderecoLogradouro());
//        user.setEnderecoNumero(alunoEaDTO.getEnderecoNumero());
//        user.setEnderecoComplemento(alunoEaDTO.getEnderecoComplemento());
//        user.setEnderecoBairro(alunoEaDTO.getEnderecoBairro());
//        user.setEnderecoCidade(alunoEaDTO.getEnderecoCidade());
//        user.setEnderecoUf(alunoEaDTO.getEnderecoUf());
//        user.setEnderecoObservacao(alunoEaDTO.getEnderecoObservacao());

//        user.setCepEntLivro(alunoEaDTO.getCepEntLivro());
//        user.setLogradouroEntLivro(alunoEaDTO.getLogradouroEntLivro());
//        user.setNumeroEntLivro(alunoEaDTO.getNumeroEntLivro());
//        user.setComplementoEntLivro(alunoEaDTO.getComplementoEntLivro());
//        user.setBairroEntLivro (alunoEaDTO.getBairroEntLivro());
//        user.setCidadeEntLivro (alunoEaDTO.getCidadeEntLivro());
//        user.setUfEntLivro (alunoEaDTO.getUfEntLivro());
//        user.setObservacaoEntLivro (alunoEaDTO.getObservacaoEntLivro());

        user = userRepository.save(user);
        this.clearUserCaches(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param alunoEaDTO user to update
     * @return updated user
     */
    public Optional<AlunoEaDTO> updateAlunoEa(AlunoEaDTO alunoEaDTO) {

        return Optional.of(userRepository
            .findById(alunoEaDTO.getId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(user -> {
                this.clearUserCaches(user);
                user.setLogin(alunoEaDTO.getLogin().toLowerCase());
                user.setName(alunoEaDTO.getName());
                user.setEmail(alunoEaDTO.getEmail().toLowerCase());
                user.setImageUrl(alunoEaDTO.getImageUrl());
                user.setActivated(alunoEaDTO.isActivated());
                user.setLangKey(alunoEaDTO.getLangKey());
                Set<Authority> managedAuthorities = user.getAuthorities();

                managedAuthorities.clear();
                if (Objects.isNull(alunoEaDTO.getAuthorities())) {
                    alunoEaDTO.setAuthorities(new HashSet<>());
                    alunoEaDTO.getAuthorities().add(AuthoritiesConstants.USER);
                }

                if (Objects.nonNull(alunoEaDTO.getAuthorities())) {
                    alunoEaDTO.getAuthorities().stream()
                        .map(authorityRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(managedAuthorities::add);
                }
                this.clearUserCaches(user);
                log.debug("Changed Information for User: {}", user);
                return user;
            })
            .map(AlunoEaDTO::new);
    }
    /*---------------------------------------------------------*/


    //FORMULA: ANO + HORA + MINUTO + ID ALUNO + SEPARADOR(-) + NUMERO ESCOLA
    protected String gerarMatricula(User usuario) {
        StringBuffer matricula = new StringBuffer();

        matricula.append(LocalDate.now().getYear()); //ADICIONA O ANO
        matricula.append(LocalDateTime.now().getHour()); // HORA
        matricula.append(LocalDateTime.now().getMinute()); // MINUTO
        matricula.append(usuario.getId()); //ID DO ALUNO
        return matricula.toString();
    }

    private void clearUserCaches(User user) {
        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_LOGIN_CACHE)).evict(user.getLogin());
        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE)).evict(user.getEmail());
    }

    public void deleteUser(String login) {
        userRepository.findOneByLogin(login).ifPresent(user -> {
            userRepository.delete(user);
            this.clearUserCaches(user);
            log.debug("Deleted User: {}", user);
        });
    } //so quem tem curso professor

    @Transactional(readOnly = true)
    public Page<AlunoEaDTO> getAllAlunosEa(Pageable pageable) {
        return userRepository.buscarUsuariosPadroes(pageable).map(AlunoEaDTO::new);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        return userRepository.findOneWithAuthoritiesByLogin(login);
    }

    /**
     * @return a list of all the authorities
     */
    public List<String> getAuthorities() {
        return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
    }
}
