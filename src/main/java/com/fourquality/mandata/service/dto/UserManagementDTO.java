package com.fourquality.mandata.service.dto;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.Authority;
import com.fourquality.mandata.domain.User;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a User, with his authorities.
 */
public class UserManagementDTO {
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

    // novos
    private String cnpj;

    private String cpf;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    private String foneFixo;

    private String foneCel;

    private Boolean status;
    /*---------------------------------------------------------------------------------*/

    public UserManagementDTO() {}

    public UserManagementDTO(User user) {
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
        this.cnpj = user.getCnpj();
        this.cpf = user.getCpf();
        this.logradouro = user.getLogradouro();
        this.numero = user.getNumero();
        this.complemento = user.getComplemento();
        this.bairro = user.getBairro();
        this.cidade = user.getCidade();
        this.uf = user.getUf();
        this.cep = user.getCep();
        this.foneFixo = user.getFoneFixo();
        this.foneCel = user.getFoneCel();
        this.status = user.isStatus();
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

    /*-------------------------------------TIPO_USUARIO------------------------------*/
    public Integer getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /*-------------------------------------------------------------------------------*/

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserManagementDTO{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated=" + activated +
            ", tipoUsuario=" + tipoUsuario +
            ", langKey='" + langKey + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            ", authorities=" + authorities +
            ", cnpj='" + cnpj + '\'' +
            ", cpf='" + cpf + '\'' +
            ", logradouro='" + logradouro + '\'' +
            ", numero='" + numero + '\'' +
            ", complemento='" + complemento + '\'' +
            ", bairro='" + bairro + '\'' +
            ", cidade='" + cidade + '\'' +
            ", uf='" + uf + '\'' +
            ", cep='" + cep + '\'' +
            ", foneFixo='" + foneFixo + '\'' +
            ", foneCel='" + foneCel + '\'' +
            ", status=" + status +
            '}';
    }
}
