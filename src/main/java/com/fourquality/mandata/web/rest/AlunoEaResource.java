package com.fourquality.mandata.web.rest;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.User;
import com.fourquality.mandata.repository.UserRepository;
import com.fourquality.mandata.security.AuthoritiesConstants;
import com.fourquality.mandata.service.AlunoEaService;
import com.fourquality.mandata.service.MailService;
import com.fourquality.mandata.service.dto.AlunoEaDTO;
import com.fourquality.mandata.web.rest.errors.BadRequestAlertException;
import com.fourquality.mandata.web.rest.errors.EmailAlreadyUsedException;
import com.fourquality.mandata.web.rest.errors.LoginAlreadyUsedException;
import com.fourquality.mandata.web.rest.util.HeaderUtil;
import com.fourquality.mandata.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AlunoEaResource {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserRepository userRepository;

    private final AlunoEaService alunoEaService;

    private final MailService mailService;

    public AlunoEaResource(UserRepository userRepository, MailService mailService, AlunoEaService alunoEaService) {
        this.alunoEaService = alunoEaService;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    /**
     * POST  /users  : Creates a new user.
     * <p>
     * Creates a new user if the login and email are not already used, and sends an
     * mail with an activation link.
     * The user needs to be activated on creation.
     *
     * @param alunoEaDTO the user to create
     * @return the ResponseEntity with status 201 (Created) and with body the new user, or with status 400 (Bad Request) if the login or email is already in use
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * @throws com.fourquality.mandata.web.rest.errors.BadRequestAlertException 400 (Bad Request) if the login or email is already in use
     */
    @PostMapping("/aluno-ea")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<User> createUser(@Valid @RequestBody AlunoEaDTO alunoEaDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", alunoEaDTO);

        if (Objects.isNull(alunoEaDTO.getLogin())) {
            alunoEaDTO.setLogin(alunoEaDTO.getEmail());
        }
        if (alunoEaDTO.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else if (userRepository.findOneByLogin(alunoEaDTO.getLogin().toLowerCase()).isPresent()) {
            throw new LoginAlreadyUsedException();
        } else if (userRepository.findOneByEmailIgnoreCase(alunoEaDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        } else {
            User newUser = null;
            Object[] tipoPefil = alunoEaDTO.getAuthorities().toArray();
            newUser = alunoEaService.createAlunoEa(alunoEaDTO);
            mailService.sendCreationEmail(newUser);

            return ResponseEntity.created(new URI("/api/aluno-ea/" + newUser.getLogin()))
                .headers(HeaderUtil.createAlert("userManagement.created", newUser.getLogin()))
                .body(newUser);
        }
    }

    /**
     * PUT /users : Updates an existing User.
     *
     * @param alunoEaDTO the user to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated user
     * @throws EmailAlreadyUsedException 400 (Bad Request) if the email is already in use
     * @throws LoginAlreadyUsedException 400 (Bad Request) if the login is already in use
     */
    @PutMapping("/aluno-ea")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<AlunoEaDTO> updateAlunoCeteb(@Valid @RequestBody AlunoEaDTO alunoEaDTO) {
        log.debug("REST request to update User : {}", alunoEaDTO);
        Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(alunoEaDTO.getEmail());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(alunoEaDTO.getId()))) {
            throw new EmailAlreadyUsedException();
        }
        existingUser = userRepository.findOneByLogin(alunoEaDTO.getLogin().toLowerCase());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(alunoEaDTO.getId()))) {
            throw new LoginAlreadyUsedException();
        }
        Object[] tipoPefil = alunoEaDTO.getAuthorities().toArray();
        Optional<AlunoEaDTO> updatedUser = null;

        updatedUser = alunoEaService.updateAlunoEa(alunoEaDTO);

        return ResponseUtil.wrapOrNotFound(updatedUser,
            HeaderUtil.createAlert("userManagement.updated", alunoEaDTO.getLogin()));
    }

    /**
     * GET /users : get all users.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping("/aluno-ea")
    public ResponseEntity<List<AlunoEaDTO>> getAllAlunoEa(Pageable pageable) {
        Page<AlunoEaDTO> page = null;
        page = alunoEaService.getAllAlunosEa(pageable);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/aluno-ea");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/aluno-ea/{login:" + Constants.LOGIN_REGEX + "}")
    public ResponseEntity<AlunoEaDTO> getUser(@PathVariable String login) {
        log.debug("REST request to get User : {}", login);
        return ResponseUtil.wrapOrNotFound(
            alunoEaService.getUserWithAuthoritiesByLogin(login)
                .map(user -> {
                    AlunoEaDTO alunoEaDTO = new AlunoEaDTO();
                    alunoEaDTO.setId(user.getId());
                    alunoEaDTO.setLogin(user.getLogin().toLowerCase());
                    alunoEaDTO.setName(user.getName());
                    alunoEaDTO.setEmail(user.getEmail().toLowerCase());
                    alunoEaDTO.setImageUrl(user.getImageUrl());
                    alunoEaDTO.setActivated(user.getActivated());
                    alunoEaDTO.setLangKey(user.getLangKey());
                    alunoEaDTO.setAuthorities(user.getAuthorities().stream().map(item -> item.getName()).collect(Collectors.toSet()));
                    alunoEaDTO.setCreatedBy(user.getCreatedBy());
                    alunoEaDTO.setCreatedDate(user.getCreatedDate());
                    alunoEaDTO.setLastModifiedBy(user.getLastModifiedBy());
                    alunoEaDTO.setLastModifiedDate(user.getLastModifiedDate());

                    return  alunoEaDTO;
                }));
    }

    /**
     * @return a string list of the all of the roles
     */
    @GetMapping("/aluno-ea/authorities")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public List<String> getAuthorities() {
        return alunoEaService.getAuthorities();
    }

    /*
 *   Filtro de usuarios atráves do atributo nome
 */
    @GetMapping("/aluno-ea/nomeFiltro")
    public ResponseEntity<List<User>> getByNome(@RequestParam(value = "nome") String nome, Pageable pageable) {
        Page<User> page = userRepository.buscarPorNome(nome, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/aluno-ea");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * DELETE /users/:login : delete the "login" User.
     *
     * @param login the login of the user to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/aluno-ea/{login:" + Constants.LOGIN_REGEX + "}")
    @PreAuthorize("hasRole(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        log.debug("REST request to delete User: {}", login);
        alunoEaService.deleteUser(login);
        return ResponseEntity.ok().headers(HeaderUtil.createAlert( "userManagement.deleted", login)).build();
    }
}
