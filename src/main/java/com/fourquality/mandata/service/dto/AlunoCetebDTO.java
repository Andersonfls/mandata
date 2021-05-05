package com.fourquality.mandata.service.dto;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.Authority;
import com.fourquality.mandata.domain.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a Aluno type Mandata, with his authorities.
 */
public class AlunoCetebDTO {
    /*----------------Padrão criado pelo jhipster e configurações-------------------------*/
    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String name;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    private boolean activated = false;

    private Integer tipoUsuario;

    @Size(min = 2, max = 6)
    private String langKey;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> authorities;
    /*---------------------------------------------------------------------------------*/

//    private LocalDate dataNascimento;
//
//    private String estadoCivil;
//
//    private String sexo;
//
//    private String cpf;
//
//    private String nacionalidade;
//
//    private String naturalidade;
//
//    private String naturalidadeUf;
//
//    private String cep;
//
//    private String enderecoLogradouro;
//
//    private String enderecoNumero;
//
//    private String enderecoComplemento;
//
//    private String enderecoBairro;
//
//    private String enderecoCidade;
//
//    private String enderecoUf;
//
//    private String enderecoObservacao;
//
//    private String telefone;
//
//    private String celular;
//
//    private String corRaca;
//
//    private String nomePai;
//
//    private String nomeMae;
//
//    private String nomeSocial;
//
//    private String alergias;
//
//    private boolean decisaoJudicial;
//
//    private Boolean necessidadesEspeciais;
//
//    private String necessidadesEspeciaisObs;
//
//    private String conhecimentoEscola;
//
//    private String responsavelFinanceiro;
//
//    private String telefoneRespFinanceiro;
//
//    private String rgRespFinanceiro;
//
//    private String cpfRespFinanceiro;
//
//    private String emailRespFinanceiro;
//
//    private String cepRespFinanceiro;
//
//    private String logradouroRespFinanceiro;
//
//    private String numeroRespFinanceiro;
//
//    private String complementoRespFinanceiro;
//
//    private String bairroRespFinanceiro;
//
//    private String cidadeRespFinanceiro;
//
//    private String ufRespFinanceiro;
//
//    private String celularRespFinanceiro;
//
//    private String grauParentescoRespFinanceiro;
//
//    private Boolean financIgualPedago;
//
//    private String responsavelPedagogico;
//
//    private String telefoneRespPedagogico;
//
//    private String rgRespPedagogico;
//
//    private String cpfRespPedagogico;
//
//    private String emailRespPedagogico;
//
//    private String cepRespPedagogico;
//
//    private String logradouroRespPedagogico;
//
//    private String numeroRespPedagogico;
//
//    private String complementoRespPedagogico;
//
//    private String bairroRespPedagogico;
//
//    private String cidadeRespPedagogico;
//
//    private String ufRespPedagogico;
//
//    private String celularRespPedagogico;
//
//    private String grauParentescoRespPedagogico;

    public AlunoCetebDTO() {
        // Empty constructor needed for Jackson.
    }

    public AlunoCetebDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.name = user.getName();
        this.email = user.getEmail();
        this.activated = user.getActivated();
        this.imageUrl = user.getImageUrl();
        this.langKey = user.getLangKey();
        this.createdBy = user.getCreatedBy();
        this.createdDate = user.getCreatedDate();
        this.lastModifiedBy = user.getLastModifiedBy();
        this.lastModifiedDate = user.getLastModifiedDate();
        this.authorities = user.getAuthorities().stream()
            .map(Authority::getName)
            .collect(Collectors.toSet());
    }

    /*-----------------ID---------------------*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /*----------------------------------------*/

    /*------------------------LOGIN-------------------------*/
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    /*------------------------------------------------------*/

    /*---------------------NAME-------------------------*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*--------------------------------------------------*/

    /*------------------------EMAIL-------------------------*/
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /*------------------------------------------------------*/

    /*------------------------IMAGE_URL---------------------------------*/
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    /*------------------------------------------------------------------*/

    /*-------------------------------ACTIVATED-------------------------------*/
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    /*-----------------------------------------------------------------------*/

    /*------------------------LANG_KEY------------------------------*/
    public String getLangKey() {
        return langKey;
    }
    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }
    /*--------------------------------------------------------------*/

    /*-----------------------------CREATE_BY--------------------------------*/
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------------------CREATE_DATE--------------------------------*/
    public Instant getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
    /*-------------------------------------------------------------------------------*/

    /*------------------------------LAST_MODIFIED_BY--------------------------------------------*/
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    /*------------------------------------------------------------------------------------------*/

    /*------------------------------------LAST_MODIFIED_DATE---------------------------------------------*/
    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    /*---------------------------------------------------------------------------------------------------*/

    /*------------------------------------AUTHORITIES------------------------------------*/
    public Set<String> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
    /*----------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "UserDTO{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated=" + activated +
            ", langKey='" + langKey + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            ", authorities=" + authorities +
            '}';
    }
}
