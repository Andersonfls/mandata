package com.fourquality.mandata.service.dto;

import com.fourquality.mandata.config.Constants;
import com.fourquality.mandata.domain.Authority;
import com.fourquality.mandata.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a Aluno type Ea, with his authorities.
 */
public class AlunoEaDTO {
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

    private LocalDate dataNascimento;

    private String estadoCivil;

    private String sexo;

    private String cpf;

    private String nacionalidade;

    private String naturalidade;

    private String naturalidadeUf;

    private String grauInstrucao;

    private String profissao;

    private String cep;

    private String enderecoLogradouro;

    private String enderecoNumero;

    private String enderecoComplemento;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoUf;

    private String enderecoObservacao;

    private String telefone;

    private String celular;

    private String corRaca;

    private String cepEntLivro;

    private String logradouroEntLivro;

    private String numeroEntLivro;

    private String complementoEntLivro;

    private String bairroEntLivro;

    private String cidadeEntLivro;

    private String ufEntLivro;

    private String observacaoEntLivro;

    private Boolean licencaCapacitacao;


    public AlunoEaDTO() {
    }

    public AlunoEaDTO(User user) {
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
//        this.dataNascimento = user.getDataNascimento();
//        this.sexo = user.getSexo();
//        this.cpf = user.getCpf();
//        this.nacionalidade = user.getNacionalidade();
//        this.naturalidade = user.getNaturalidade();
//        this.naturalidadeUf = user.getNaturalidadeUf();
//        this.grauInstrucao = user.getGrauInstrucao();
//        this.telefone = user.getTelefone();
//        this.profissao = user.getProfissao();
//        this.celular = user.getCelular();
//        this.estadoCivil = user.getEstadoCivil();
//        this.cep = user.getCep();
//        this.enderecoLogradouro = user.getEnderecoLogradouro();
//        this.enderecoNumero = user.getEnderecoNumero();
//        this.enderecoComplemento = user.getEnderecoComplemento();
//        this.enderecoBairro = user.getEnderecoBairro();
//        this.enderecoCidade = user.getEnderecoCidade();
//        this.enderecoUf = user.getEnderecoUf();
//        this.enderecoObservacao = user.getEnderecoObservacao();
//        this.tipoUsuario = user.getTipoUsuario();
//        this.cepEntLivro = user.getCepEntLivro();
//        this.logradouroEntLivro = user.getLogradouroEntLivro();
//        this.numeroEntLivro = user.getNumeroEntLivro();
//        this.complementoEntLivro = user.getComplementoEntLivro();
//        this.bairroEntLivro = user.getBairroEntLivro();
//        this.cidadeEntLivro = user.getCidadeEntLivro();
//        this.ufEntLivro = user.getUfEntLivro();
//        this.observacaoEntLivro = user.getObservacaoEntLivro();
//        this.corRaca = user.getCorRaca();
//        this.licencaCapacitacao = user.getLicencaCapacitacao();
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

    /*------------------------------------DATA_NASCIMENTO------------------------------------------*/
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    /*---------------------------------------------------------------------------------------------*/

    /*--------------------SEXO--------------------------*/
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /*--------------------------------------------------*/

    /*-------------------CPF------------------------*/
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /*----------------------------------------------*/

    /*----------------------------------GRAU_INSTRUCAO--------------------------------------*/
    public String getGrauInstrucao() {
        return grauInstrucao;
    }
    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }
    /*--------------------------------------------------------------------------------------*/

    /*---------------------CEP----------------------*/
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    /*----------------------------------------------*/

    /*-------------------------------------ENDERECO_LOGADOURO---------------------------------------------------*/
    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }
    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }
    /*----------------------------------------------------------------------------------------------------------*/

    /*------------------------------------ENDERECO_NUMERO---------------------------------------*/
    public String getEnderecoNumero() {
        return enderecoNumero;
    }
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }
    /*------------------------------------------------------------------------------------------*/

    /*------------------------------------ENDERECO_COMPLEMENTO------------------------------------------------------*/
    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }
    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }
    /*--------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------ENDERECO_BAIRRO---------------------------------------*/
    public String getEnderecoBairro() {
        return enderecoBairro;
    }
    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }
    /*------------------------------------------------------------------------------------------*/

    /*------------------------------------ENDERECO_CIDADE---------------------------------------*/
    public String getEnderecoCidade() {
        return enderecoCidade;
    }
    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }
    /*------------------------------------------------------------------------------------------*/

    /*-----------------------------ENDERECO_UF----------------------------------*/
    public String getEnderecoUf() {
        return enderecoUf;
    }
    public void setEnderecoUf(String enderecoUf) {
        this.enderecoUf = enderecoUf;
    }
    /*--------------------------------------------------------------------------*/

    /*--------------------------------------------ENDERECO_OBSERVACAO-------------------------------------------*/
    public String getEnderecoObservacao() {
        return enderecoObservacao;
    }
    public void setEnderecoObservacao(String enderecoObservacao) {
        this.enderecoObservacao = enderecoObservacao;
    }
    /*----------------------------------------------------------------------------------------------------------*/

    /*------------------------------TELEFONE----------------------------*/
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /*------------------------------------------------------------------*/

    /*-----------------------CELULAR--------------------------------*/
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    /*--------------------------------------------------------------*/

    /*-------------------------------------TIPO_USUARIO------------------------------*/
    public Integer getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /*-------------------------------------------------------------------------------*/

    /*----------------------------ESTADO_CIVIl--------------------------------------*/
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    /*------------------------------------------------------------------------------*/

    /*---------------------------------NACIONALIDADE----------------------------------------*/
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    /*--------------------------------------------------------------------------------------*/

    /*-----------------------------NATURALIDADE-----------------------------------------*/
    public String getNaturalidade() {
        return naturalidade;
    }
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
    /*----------------------------------------------------------------------------------*/

    /*------------------------------NATURALIDADE_UF---------------------------------------------*/
    public String getNaturalidadeUf() {
        return naturalidadeUf;
    }
    public void setNaturalidadeUf(String naturalidadeUf) {
        this.naturalidadeUf = naturalidadeUf;
    }
    /*------------------------------------------------------------------------------------------*/

    /*----------------------------PROFISSAO--------------------------------*/
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------------------CEP_LIVRO---------------------------------*/
    public String getCepEntLivro() {
        return cepEntLivro;
    }
    public void setCepEntLivro(String cepEntLivro) {
        this.cepEntLivro = cepEntLivro;
    }
    /*------------------------------------------------------------------------------*/

    /*----------------------------------------------ENDERECO_LIVRO---------------------------------------*/
    public String getLogradouroEntLivro() {
        return logradouroEntLivro;
    }
    public void setLogradouroEntLivro(String logradouroEntLivro) {
        this.logradouroEntLivro = logradouroEntLivro;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*---------------------------------------NUMERO_LIVRO---------------------------------------*/
    public String getNumeroEntLivro() {
        return numeroEntLivro;
    }
    public void setNumeroEntLivro(String numeroEntLivro) {
        this.numeroEntLivro = numeroEntLivro;
    }
    /*------------------------------------------------------------------------------------------*/

    /*------------------------------------------------COMPLEMENTO_LIVRO---------------------------------------------*/
    public String getComplementoEntLivro() {
        return complementoEntLivro;
    }
    public void setComplementoEntLivro(String complementoEntLivro) {
        this.complementoEntLivro = complementoEntLivro;
    }
    /*--------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------BAIRRO_LIVRO------------------------------------------*/
    public String getBairroEntLivro() {
        return bairroEntLivro;
    }
    public void setBairroEntLivro(String bairroEntLivro) {
        this.bairroEntLivro = bairroEntLivro;
    }
    /*------------------------------------------------------------------------------------------*/

    /*---------------------------------------CIDADE_LIVRO---------------------------------------*/
    public String getCidadeEntLivro() {
        return cidadeEntLivro;
    }
    public void setCidadeEntLivro(String cidadeEntLivro) {
        this.cidadeEntLivro = cidadeEntLivro;
    }
    /*------------------------------------------------------------------------------------------*/

    /*------------------------------UF_LIVRO------------------------------------*/
    public String getUfEntLivro() {
        return ufEntLivro;
    }
    public void setUfEntLivro(String ufEntLivro) {
        this.ufEntLivro = ufEntLivro;
    }
    /*--------------------------------------------------------------------------*/

    /*-----------------------------------OBSERVACAO_LIVRO-------------------------------------------------------*/
    public String getObservacaoEntLivro() {
        return observacaoEntLivro;
    }
    public void setObservacaoEntLivro(String observacaoEntLivro) {
        this.observacaoEntLivro = observacaoEntLivro;
    }
    /*----------------------------------------------------------------------------------------------------------*/

    /*---------------------------COR_RACA---------------------------*/
    public String getCorRaca() {
        return corRaca;
    }
    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }
    /*--------------------------------------------------------------*/

    /*------------------------------------------------LICENCA_CACIPATACAO----------------------------------------*/
    public Boolean getLicencaCapacitacao() {
        return licencaCapacitacao;
    }
    public void setLicencaCapacitacao(Boolean licencaCapacitacao) {
        this.licencaCapacitacao = licencaCapacitacao;
    }
    /*-----------------------------------------------------------------------------------------------------------*/

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
            ", dataNascimento=" + dataNascimento +
            ", sexo=" + sexo +
            ", cpf=" + cpf +
            ", grauInstrucao=" + grauInstrucao +
            ", telefone=" + telefone +
            ", celular=" + celular +
            ", cep=" + cep +
            ", enderecoLogradouro=" + enderecoLogradouro +
            ", enderecoNumero=" + enderecoNumero +
            ", enderecoComplemento=" + enderecoComplemento +
            ", enderecoBairro=" + enderecoBairro +
            ", enderecoCidade=" + enderecoCidade +
            ", enderecoUf=" + enderecoUf +
            ", enderecoObservacao=" + enderecoObservacao +
            ", estadoCivil=" + estadoCivil +
            ", nacionalidade=" + nacionalidade +
            ", naturalidade=" + naturalidade +
            ", naturalidadeUf=" + naturalidadeUf +
            ", profissao=" + profissao +
            ", corRaca=" + corRaca +
            ", cepEntLivro=" + cepEntLivro +
            ", enderecoEntLivro=" + logradouroEntLivro +
            ", numeroEntLivro=" + numeroEntLivro +
            ", complementoEntLivro=" + complementoEntLivro +
            ", bairroEntLivro=" + bairroEntLivro +
            ", cidadeEntLivro=" + cidadeEntLivro +
            ", ufEntLivro=" + ufEntLivro +
            ", observacaoEntLivro=" + observacaoEntLivro +
            '}';
    }
}
