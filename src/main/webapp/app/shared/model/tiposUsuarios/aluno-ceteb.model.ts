export interface IAlunoCeteb {
    id?: any;
    login?: string;
    name?: string;
    email?: string;
    activated?: boolean;
    langKey?: string;
    authorities?: any[];
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
    password?: string;

    matricula?: string;
    dataNascimento?: Date;
    sexo?: string;
    estadoCivil?: string;
    cpf?: string;
    corRaca?: string;
    nacionalidade?: string;
    naturalidade?: string;
    naturalidadeUf?: string;

    cep?: string;
    enderecoLogradouro?: string;
    enderecoNumero?: string;
    enderecoComplemento?: string;
    enderecoBairro?: string;
    enderecoCidade?: string;
    enderecoUf?: string;
    enderecoObservacao?: string;

    telefone?: string;
    celular?: string;
    nomeSocial?: string;
    alergias?: string;
    nomePai?: string;
    nomeMae?: string;
    decisaoJudicial?: boolean;
    necessidadesEspeciais?: boolean;
    necessidadesEspeciaisObs?: string;
    documentoFaltante?: string;

    responsavelFinanceiro?: string;
    telefoneRespFinanceiro?: string;
    rgRespFinanceiro?: string;
    cpfRespFinanceiro?: string;
    celularRespFinanceiro?: string;
    emailRespFinanceiro?: string;
    cepRespFinanceiro?: string;
    logradouroRespFinanceiro?: string;
    numeroRespFinanceiro?: string;
    complementoRespFinanceiro?: string;
    bairroRespFinanceiro?: string;
    cidadeRespFinanceiro?: string;
    ufRespFinanceiro?: string;
    grauParentescoRespFinanceiro?: string;
    financIgualPedago?: boolean;

    responsavelPedagogico?: string;
    telefoneRespPedagogico?: string;
    celularRespPedagogico?: string;
    rgRespPedagogico?: string;
    cpfRespPedagogico?: string;
    emailRespPedagogico?: string;
    cepRespPedagogico?: string;
    logradouroRespPedagogico?: string;
    numeroRespPedagogico?: string;
    complementoRespPedagogico?: string;
    bairroRespPedagogico?: string;
    cidadeRespPedagogico?: string;
    ufRespPedagogico?: string;
    grauParentescoRespPedagogico?: string;

    conhecimentoEscola?: string;
    tipoUsuario?: number;
}

export class AlunoCeteb implements IAlunoCeteb {
    constructor(
        public id?: any,
        public login?: string,
        public name?: string,
        public email?: string,
        public activated?: boolean,
        public langKey?: string,
        public authorities?: any[],
        public createdBy?: string,
        public createdDate?: Date,
        public lastModifiedBy?: string,
        public lastModifiedDate?: Date,
        public password?: string,
        public matricula?: string,
        public dataNascimento?: Date,
        public sexo?: string,
        public estadoCivil?: string,
        public cpf?: string,
        public corRaca?: string,
        public nacionalidade?: string,
        public naturalidade?: string,
        public naturalidadeUf?: string,
        public cep?: string,
        public enderecoLogradouro?: string,
        public enderecoNumero?: string,
        public enderecoComplemento?: string,
        public enderecoBairro?: string,
        public enderecoCidade?: string,
        public enderecoUf?: string,
        public enderecoObservacao?: string,
        public telefone?: string,
        public celular?: string,
        public nomeSocial?: string,
        public alergias?: string,
        public nomePai?: string,
        public nomeMae?: string,
        public decisaoJudicial?: boolean,
        public necessidadesEspeciais?: boolean,
        public necessidadesEspeciaisObs?: string,
        public documentoFaltante?: string,
        public responsavelFinanceiro?: string,
        public telefoneRespFinanceiro?: string,
        public celularRespFinanceiro?: string,
        public rgRespFinanceiro?: string,
        public cpfRespFinanceiro?: string,
        public emailRespFinanceiro?: string,
        public cepRespFinanceiro?: string,
        public logradouroRespFinanceiro?: string,
        public numeroRespFinanceiro?: string,
        public complementoRespFinanceiro?: string,
        public bairroRespFinanceiro?: string,
        public cidadeRespFinanceiro?: string,
        public ufRespFinanceiro?: string,
        public grauParentescoRespFinanceiro?: string,
        public financIgualPedago?: boolean,
        public responsavelPedagogico?: string,
        public telefoneRespPedagogico?: string,
        public celularRespPedagogico?: string,
        public rgRespPedagogico?: string,
        public cpfRespPedagogico?: string,
        public emailRespPedagogico?: string,
        public cepRespPedagogico?: string,
        public logradouroRespPedagogico?: string,
        public numeroRespPedagogico?: string,
        public complementoRespPedagogico?: string,
        public bairroRespPedagogico?: string,
        public cidadeRespPedagogico?: string,
        public ufRespPedagogico?: string,
        public grauParentescoRespPedagogico?: string,
        public conhecimentoEscola?: string,
        public tipoUsuario?: number
    ) {
        this.id = id ? id : null;
        this.login = login ? login : null;
        this.name = name ? name : null;
        this.email = email ? email : null;
        this.activated = activated ? activated : false;
        this.langKey = langKey ? langKey : null;
        this.authorities = authorities ? authorities : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
        this.password = password ? password : null;

        this.matricula = matricula ? matricula : null;
        this.dataNascimento = dataNascimento ? dataNascimento : null;
        this.sexo = sexo ? sexo : null;
        this.estadoCivil = estadoCivil ? estadoCivil : null;
        this.cpf = cpf ? cpf : null;
        this.corRaca = corRaca ? corRaca : null;
        this.nacionalidade = nacionalidade ? nacionalidade : null;
        this.naturalidade = naturalidade ? naturalidade : null;
        this.naturalidadeUf = naturalidadeUf ? naturalidadeUf : null;

        this.cep = cep ? cep : null;
        this.enderecoLogradouro = enderecoLogradouro ? enderecoLogradouro : null;
        this.enderecoNumero = enderecoNumero ? enderecoNumero : null;
        this.enderecoComplemento = enderecoComplemento ? enderecoComplemento : null;
        this.enderecoBairro = enderecoBairro ? enderecoBairro : null;
        this.enderecoCidade = enderecoCidade ? enderecoCidade : null;
        this.enderecoUf = enderecoUf ? enderecoUf : null;
        this.enderecoObservacao = enderecoObservacao ? enderecoObservacao : null;

        this.telefone = telefone ? telefone : null;
        this.celular = celular ? celular : null;
        this.nomeSocial = nomeSocial ? nomeSocial : null;
        this.alergias = alergias ? alergias : null;
        this.nomePai = nomePai ? nomePai : null;
        this.nomeMae = nomeMae ? nomeMae : null;
        this.decisaoJudicial = decisaoJudicial ? decisaoJudicial : null;
        this.necessidadesEspeciais = necessidadesEspeciais ? necessidadesEspeciais : null;
        this.necessidadesEspeciaisObs = necessidadesEspeciaisObs ? necessidadesEspeciaisObs : null;
        this.documentoFaltante = documentoFaltante ? documentoFaltante : null;

        this.responsavelFinanceiro = responsavelFinanceiro ? responsavelFinanceiro : null;
        this.telefoneRespFinanceiro = telefoneRespFinanceiro ? telefoneRespFinanceiro : null;
        this.celularRespFinanceiro = celularRespFinanceiro ? celularRespFinanceiro : null;
        this.rgRespFinanceiro = rgRespFinanceiro ? rgRespFinanceiro : null;
        this.cpfRespFinanceiro = cpfRespFinanceiro ? cpfRespFinanceiro : null;
        this.emailRespFinanceiro = emailRespFinanceiro ? emailRespFinanceiro : null;
        this.cepRespFinanceiro = cepRespFinanceiro ? cepRespFinanceiro : null;
        this.logradouroRespFinanceiro = logradouroRespFinanceiro ? logradouroRespFinanceiro : null;
        this.numeroRespFinanceiro = numeroRespFinanceiro ? numeroRespFinanceiro : null;
        this.complementoRespFinanceiro = complementoRespFinanceiro ? complementoRespFinanceiro : null;
        this.bairroRespFinanceiro = bairroRespFinanceiro ? bairroRespFinanceiro : null;
        this.cidadeRespFinanceiro = cidadeRespFinanceiro ? cidadeRespFinanceiro : null;
        this.ufRespFinanceiro = ufRespFinanceiro ? ufRespFinanceiro : null;
        this.grauParentescoRespFinanceiro = grauParentescoRespFinanceiro ? grauParentescoRespFinanceiro : null;
        this.financIgualPedago = financIgualPedago ? financIgualPedago : null;

        this.responsavelPedagogico = responsavelPedagogico ? responsavelPedagogico : null;
        this.telefoneRespPedagogico = telefoneRespPedagogico ? telefoneRespPedagogico : null;
        this.celularRespPedagogico = celularRespPedagogico ? celularRespPedagogico : null;
        this.rgRespPedagogico = rgRespPedagogico ? rgRespPedagogico : null;
        this.cpfRespPedagogico = cpfRespPedagogico ? cpfRespPedagogico : null;
        this.emailRespPedagogico = emailRespPedagogico ? emailRespPedagogico : null;
        this.cepRespPedagogico = cepRespPedagogico ? cepRespPedagogico : null;
        this.logradouroRespPedagogico = logradouroRespPedagogico ? logradouroRespPedagogico : null;
        this.numeroRespPedagogico = numeroRespPedagogico ? numeroRespPedagogico : null;
        this.complementoRespPedagogico = complementoRespPedagogico ? complementoRespPedagogico : null;
        this.bairroRespPedagogico = bairroRespPedagogico ? bairroRespPedagogico : null;
        this.cidadeRespPedagogico = cidadeRespPedagogico ? cidadeRespPedagogico : null;
        this.ufRespPedagogico = ufRespPedagogico ? ufRespPedagogico : null;
        this.grauParentescoRespPedagogico = grauParentescoRespPedagogico ? grauParentescoRespPedagogico : null;

        this.conhecimentoEscola = conhecimentoEscola ? conhecimentoEscola : null;

        this.tipoUsuario = tipoUsuario ? tipoUsuario : null;
    }
}
