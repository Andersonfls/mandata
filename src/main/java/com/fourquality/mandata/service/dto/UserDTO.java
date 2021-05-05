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
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

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

    private LocalDate dataNascimento;

    private String sexo;

    private String estadoCivil;

    private String cpf;

    private String nacionalidade;

    private String naturalidade;

    private String naturalidadeUf;

    private String grauInstrucao;

    private String profissao;

    private String cargo;

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

    private String nomeRepresentante;

    private Boolean licencaCapacitacao;

    private String cepEntLivro;

    private String logradouroEntLivro;

    private String numeroEntLivro;

    private String complementoEntLivro;

    private String bairroEntLivro;

    private String cidadeEntLivro;

    private String ufEntLivro;

    private String observacaoEntLivro;

    private String nomeSocial;

    private String cidadeNascimento;

    private String ufNascimento;

    private String corRaca;

    private String alergias;

    private String responsavelFinanceiro;

    private String telefoneRespFinanceiro;

    private String rgRespFinanceiro;

    private String cpfRespFinanceiro;

    private String emailRespFinanceiro;

    private String cepRespFinanceiro;

    private String logradouroRespFinanceiro;

    private String numeroRespFinanceiro;

    private String complementoRespFinanceiro;

    private String bairroRespFinanceiro;

    private String cidadeRespFinanceiro;

    private String ufRespFinanceiro;

    private String responsavelPedagogico;

    private String telefoneRespPedagogico;

    private String rgRespPedagogico;

    private String cpfRespPedagogico;

    private String emailRespPedagogico;

    private String cepRespPedagogico;

    private String logradouroRespPedagogico;

    private String numeroRespPedagogico;

    private String complementoRespPedagogico;

    private String bairroRespPedagogico;

    private String cidadeRespPedagogico;

    private String ufRespPedagogico;

    private String convenio;

    private Boolean necessidadesEspeciais;

    private String necessidadesEspeciaisObs;

    private String documentoFaltante;

    private String conhecimentoEscola;

    private String tpContrato;

    private String formaPagamento;

    private String vendendo;

    private String filicacao;

    private String tipoCadastro;

    private String nomePai;

    private String nomeMae;

    private String celularRespFinanceiro;

    private String celularRespPedagogico;

    private boolean decisaoJudicial;

    public UserDTO() {
        // Empty constructor needed for Jackson.
    }

    public UserDTO(User user) {
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

//        this.cpf = user.getCpf();
//        this.nacionalidade = user.getNacionalidade();
//        this.naturalidade = user.getNaturalidade();
//        this.naturalidadeUf = user.getNaturalidadeUf();
//        this.grauInstrucao = user.getGrauInstrucao();
//        this.profissao = user.getProfissao();
//        this.cargo = user.getCargo();
//        this.cep = user.getCep();
//        this.telefone = user.getTelefone();
//        this.celular = user.getCelular();
//        this.nomeSocial = user.getNomeSocial();
//        this.tipoUsuario = user.getTipoUsuario();
    }
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

    /*----------------------------ESTADO_CIVIl--------------------------------------*/
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    /*------------------------------------------------------------------------------*/

    /*-------------------CPF------------------------*/
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /*----------------------------------------------*/

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

    /*----------------------------------GRAU_INSTRUCAO--------------------------------------*/
    public String getGrauInstrucao() {
        return grauInstrucao;
    }
    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }
    /*--------------------------------------------------------------------------------------*/

    /*----------------------------PROFISSAO--------------------------------*/
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------CARGO-------------------------*/
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /*------------------------------------------------------*/

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

    /*------------------------------------NOME_REPRESENTANTE------------------------------------------------*/
    public String getNomeRepresentante() {
        return nomeRepresentante;
    }
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }
    /*------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------------LICENCA_CACIPATACAO----------------------------------------*/
    public Boolean getLicencaCapacitacao() {
        return licencaCapacitacao;
    }
    public void setLicencaCapacitacao(Boolean licencaCapacitacao) {
        this.licencaCapacitacao = licencaCapacitacao;
    }
    /*-----------------------------------------------------------------------------------------------------------*/

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

    /*---------------------------------NOME_SOCIAL------------------------------*/
    public String getNomeSocial() {
        return nomeSocial;
    }
    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }
    /*--------------------------------------------------------------------------*/

    /*------------------------------------CIDADE_NASCIMENTO----------------------------------------------*/
    public String getCidadeNascimento() {
        return cidadeNascimento;
    }
    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*------------------------------------UF_NASCIMENTO---------------------------------*/
    public String getUfNascimento() {
        return ufNascimento;
    }
    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }
    /*----------------------------------------------------------------------------------*/

    /*---------------------------COR_RACA---------------------------*/
    public String getCorRaca() {
        return corRaca;
    }
    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }
    /*--------------------------------------------------------------*/

    /*----------------------------ALERGIAS------------------------------*/
    public String getAlergias() {
        return alergias;
    }
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    /*------------------------------------------------------------------*/

    /*------------------------RESPONSAVEL_FINANCEIRO------------------------*/
    public String getResponsavelFinanceiro() {
        return responsavelFinanceiro;
    }
    public void setResponsavelFinanceiro(String responsavelFinanceiro) {
        this.responsavelFinanceiro = responsavelFinanceiro;
    }
    /*----------------------------------------------------------------------*/

    /*--------------------TELEFONE_RESPONSAVEL_FINANCEIRO---------------------*/
    public String getTelefoneRespFinanceiro() {
        return telefoneRespFinanceiro;
    }
    public void setTelefoneRespFinanceiro(String telefoneRespFinanceiro) {
        this.telefoneRespFinanceiro = telefoneRespFinanceiro;
    }
    /*------------------------------------------------------------------------*/

    /*------------------------------------RG_RESP_FINANCEIRO--------------------------------------------*/
    public String getRgRespFinanceiro() {
        return rgRespFinanceiro;
    }
    public void setRgRespFinanceiro(String rgRespFinanceiro) {
        this.rgRespFinanceiro = rgRespFinanceiro;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*------------------------------------CPF_RES_FINANCEIRO------------------------------------------------*/
    public String getCpfRespFinanceiro() {
        return cpfRespFinanceiro;
    }
    public void setCpfRespFinanceiro(String cpfRespFinanceiro) {
        this.cpfRespFinanceiro = cpfRespFinanceiro;
    }
    /*------------------------------------------------------------------------------------------------------*/

    /*-----------------------------------------EMAIL_RESP_FINANCEIRO------------------------------------------------*/
    public String getEmailRespFinanceiro() {
        return emailRespFinanceiro;
    }
    public void setEmailRespFinanceiro(String emailRespFinanceiro) {
        this.emailRespFinanceiro = emailRespFinanceiro;
    }
    /*--------------------------------------------------------------------------------------------------------------*/

    /*------------------------------------CEP_RESP_FINACEIRO------------------------------------------------*/
    public String getCepRespFinanceiro() {
        return cepRespFinanceiro;
    }
    public void setCepRespFinanceiro(String cepRespFinanceiro) {
        this.cepRespFinanceiro = cepRespFinanceiro;
    }
    /*------------------------------------------------------------------------------------------------------*/

    /*------------------------ENDERECO_RESP_FINANCEIRO------------------------*/
    public String getLogradouroRespFinanceiro() {
        return logradouroRespFinanceiro;
    }
    public void setLogradouroRespFinanceiro(String logradouroRespFinanceiro) {
        this.logradouroRespFinanceiro = logradouroRespFinanceiro;
    }
    /*------------------------------------------------------------------------*/

    /*------------------------NUMERO_RESP_FINANCEIRO----------------------*/
    public String getNumeroRespFinanceiro() {
        return numeroRespFinanceiro;
    }
    public void setNumeroRespFinanceiro(String numeroRespFinanceiro) {
        this.numeroRespFinanceiro = numeroRespFinanceiro;
    }
    /*--------------------------------------------------------------------*/

    /*------------------------COMPLEMENTO_RESP_FINANCEIRO---------------------------*/
    public String getComplementoRespFinanceiro() {
        return complementoRespFinanceiro;
    }
    public void setComplementoRespFinanceiro(String complementoRespFinanceiro) {
        this.complementoRespFinanceiro = complementoRespFinanceiro;
    }
    /*------------------------------------------------------------------------------*/

    public String getBairroRespFinanceiro() {
        return bairroRespFinanceiro;
    }
    public void setBairroRespFinanceiro(String bairroRespFinanceiro) {
        this.bairroRespFinanceiro = bairroRespFinanceiro;
    }
    /*-------------------------------------------------------------------------------*/

    /*------------------------CIDADE_REP_FINANCEIRO-----------------------*/
    public String getCidadeRespFinanceiro() {
        return cidadeRespFinanceiro;
    }
    public void setCidadeRespFinanceiro(String cidadeRespFinanceiro) {
        this.cidadeRespFinanceiro = cidadeRespFinanceiro;
    }
    /*--------------------------------------------------------------------*/

    /*------------------------------------UF_RESP_FINANCEIRO--------------------------------------------*/
    public String getUfRespFinanceiro() {
        return ufRespFinanceiro;
    }
    public void setUfRespFinanceiro(String ufRespFinanceiro) {
        this.ufRespFinanceiro = ufRespFinanceiro;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*-------------------------------RESP_PEDAGOGICO------------------------*/
    public String getResponsavelPedagogico() {
        return responsavelPedagogico;
    }
    public void setResponsavelPedagogico(String responsavelPedagogico) {
        this.responsavelPedagogico = responsavelPedagogico;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------TELEFONE_RESP_PEDAGOGICO------------------------*/
    public String getTelefoneRespPedagogico() {
        return telefoneRespPedagogico;
    }
    public void setTelefoneRespPedagogico(String telefoneRespPedagogico) {
        this.telefoneRespPedagogico = telefoneRespPedagogico;
    }
    /*------------------------------------------------------------------------*/

    /*-----------------------------------RG_RESP_PEDAGOGICO---------------------------------------------*/
    public String getRgRespPedagogico() {
        return rgRespPedagogico;
    }
    public void setRgRespPedagogico(String rgRespPedagogico) {
        this.rgRespPedagogico = rgRespPedagogico;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*-----------------------------------------------CPF_RESP_PEDAGOGICO------------------------------------*/
    public String getCpfRespPedagogico() {
        return cpfRespPedagogico;
    }
    public void setCpfRespPedagogico(String cpfRespPedagogico) {
        this.cpfRespPedagogico = cpfRespPedagogico;
    }
    /*------------------------------------------------------------------------------------------------------*/

    public String getEmailRespPedagogico() {
        return emailRespPedagogico;
    }
    public void setEmailRespPedagogico(String emailRespPedagogico) {
        this.emailRespPedagogico = emailRespPedagogico;
    }
    /*-------------------------------------------------------------------------------*/

    /*-----------------------------------CEP_RESP_PEDAGOGICO------------------------------------------------*/
    public String getCepRespPedagogico() {
        return cepRespPedagogico;
    }
    public void setCepRespPedagogico(String cepRespPedagogico) {
        this.cepRespPedagogico = cepRespPedagogico;
    }
    /*------------------------------------------------------------------------------------------------------*/

    /*------------------------ENDERECO_RESP_PEDAGOGICO------------------------*/
    public String getLogradouroRespPedagogico() {
        return logradouroRespPedagogico;
    }
    public void setLogradouroRespPedagogico(String logradouroRespPedagogico) {
        this.logradouroRespPedagogico = logradouroRespPedagogico;
    }
    /*------------------------------------------------------------------------*/

    /*------------------------NUMERO_RESP_PEDAGOGICO----------------------*/
    public String getNumeroRespPedagogico() {
        return numeroRespPedagogico;
    }
    public void setNumeroRespPedagogico(String numeroRespPedagogico) {
        this.numeroRespPedagogico = numeroRespPedagogico;
    }
    /*--------------------------------------------------------------------*/

    /*---------------------------COMPLEMENTO_RESP_PEDAGOGICO------------------------*/
    public String getComplementoRespPedagogico() {
        return complementoRespPedagogico;
    }
    public void setComplementoRespPedagogico(String complementoRespPedagogico) {
        this.complementoRespPedagogico = complementoRespPedagogico;
    }
    /*------------------------------------------------------------------------------*/

    /*------------------------BAIRRO_RESP_PEDAGOGICO----------------------*/
    public String getBairroRespPedagogico() {
        return bairroRespPedagogico;
    }
    public void setBairroRespPedagogico(String bairroRespPedagogico) {
        this.bairroRespPedagogico = bairroRespPedagogico;
    }
    /*--------------------------------------------------------------------*/

    /*------------------------CIDADE_RESP_PEDAGOGICO----------------------*/
    public String getCidadeRespPedagogico() {
        return cidadeRespPedagogico;
    }
    public void setCidadeRespPedagogico(String cidadeRespPedagogico) {
        this.cidadeRespPedagogico = cidadeRespPedagogico;
    }
    /*--------------------------------------------------------------------*/

    /*------------------------------------UF_RESP_PEDAGOGICO--------------------------------------------*/
    public String getUfRespPedagogico() {
        return ufRespPedagogico;
    }
    public void setUfRespPedagogico(String ufRespPedagogico) {
        this.ufRespPedagogico = ufRespPedagogico;
    }
    /*--------------------------------------------------------------------------------------------------*/

    /*----------------------------CONVENIO------------------------------*/
    public String getConvenio() {
        return convenio;
    }
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    /*------------------------------------------------------------------*/

    /*------------------------NECESSIDADES_ESPECIAIS-------------------------*/
    public Boolean getNecessidadesEspeciais() {
        return necessidadesEspeciais;
    }
    public void setNecessidadesEspeciais(Boolean necessidadesEspeciais) {
        this.necessidadesEspeciais = necessidadesEspeciais;
    }
    /*-----------------------------------------------------------------------*/

    /*------------------------NECESSIDADE_ESPECIAIS_OBS---------------------------*/
    public String getNecessidadesEspeciaisObs() {
        return necessidadesEspeciaisObs;
    }
    public void setNecessidadesEspeciaisObs(String necessidadesEspeciaisObs) {
        this.necessidadesEspeciaisObs = necessidadesEspeciaisObs;
    }
    /*----------------------------------------------------------------------------*/

    /*-----------------------------------------DOCUMENTO_FALTANTE-------------------------------------------*/
    public String getDocumentoFaltante() {
        return documentoFaltante;
    }
    public void setDocumentoFaltante(String documentoFaltante) {
        this.documentoFaltante = documentoFaltante;
    }
    /*------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------CONHECIMENTO_ESCOLA------------------------------------------------*/
    public String getConhecimentoEscola() {
        return conhecimentoEscola;
    }
    public void setConhecimentoEscola(String conhecimentoEscola) {
        this.conhecimentoEscola = conhecimentoEscola;
    }
    /*----------------------------------------------------------------------------------------------------------*/

    /*------------------------------------TP_CONTRATO---------------------------*/
    public String getTpContrato() {
        return tpContrato;
    }
    public void setTpContrato(String tpContrato) {
        this.tpContrato = tpContrato;
    }
    /*--------------------------------------------------------------------------*/

    /*------------------------------------FORMA_PAGAMENTO---------------------------------------*/
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    /*------------------------------------------------------------------------------------------*/

    /*--------------------------VENDENDO--------------------------------*/
    public String getVendendo() {
        return vendendo;
    }
    public void setVendendo(String vendendo) {
        this.vendendo = vendendo;
    }
    /*------------------------------------------------------------------*/

    /*-----------------------------FILICACAO--------------------------------*/
    public String getFilicacao() {
        return filicacao;
    }
    public void setFilicacao(String filicacao) {
        this.filicacao = filicacao;
    }
    /*----------------------------------------------------------------------*/

    /*---------------------------------TIPO_CADASTRO-------------------------------------*/
    public String getTipoCadastro() {
        return tipoCadastro;
    }
    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }
    /*----------------------------------------------------------------------------------*/

    /*------------------------NOME_PAI------------------------------*/
    public String getNomePai() {
        return nomePai;
    }
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    /*--------------------------------------------------------------*/

    /*------------------------NOME_MAE------------------------------*/
    public String getNomeMae() {
        return nomeMae;
    }
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    /*--------------------------------------------------------------*/

    /*------------------------CELULAR_RESP_FINANCEIRO-----------------------*/
    public String getCelularRespFinanceiro() {
        return celularRespFinanceiro;
    }
    public void setCelularRespFinanceiro(String celularRespFinanceiro) {
        this.celularRespFinanceiro = celularRespFinanceiro;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------CELULAR_RESP_PEDAGOGICO-----------------------*/
    public String getCelularRespPedagogico() {
        return celularRespPedagogico;
    }
    public void setCelularRespPedagogico(String celularRespPedagogico) {
        this.celularRespPedagogico = celularRespPedagogico;
    }
    /*----------------------------------------------------------------------*/

    /*------------------------------------DECISAO_JUDICIAL-------------------------------------------*/
    public boolean isDecisaoJudicial() {
        return decisaoJudicial;
    }
    public void setDecisaoJudicial(boolean decisaoJudicial) {
        this.decisaoJudicial = decisaoJudicial;
    }
    /*-----------------------------------------------------------------------------------------------*/

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
