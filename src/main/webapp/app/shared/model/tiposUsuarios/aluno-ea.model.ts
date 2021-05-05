export interface IAlunoEA {
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
    nacionalidade?: string;
    naturalidade?: string;
    naturalidadeUf?: string;
    grauInstrucao?: string;
    profissao?: string;
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
    corRaca?: string;
    licencaCapacitacao?: boolean;
    cepEntLivro?: string;
    logradouroEntLivro?: string;
    numeroEntLivro?: string;
    complementoEntLivro?: string;
    bairroEntLivro?: string;
    cidadeEntLivro?: string;
    ufEntLivro?: string;
    observacaoEntLivro?: string;

    tipoUsuario?: number;
}

export class AlunoEA implements IAlunoEA {
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
        public nacionalidade?: string,
        public naturalidade?: string,
        public naturalidadeUf?: string,
        public grauInstrucao?: string,
        public profissao?: string,
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
        public licencaCapacitacao?: boolean,
        public cepEntLivro?: string,
        public logradouroEntLivro?: string,
        public numeroEntLivro?: string,
        public complementoEntLivro?: string,
        public bairroEntLivro?: string,
        public cidadeEntLivro?: string,
        public ufEntLivro?: string,
        public corRaca?: string,
        public observacaoEntLivro?: string,
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
        this.nacionalidade = nacionalidade ? nacionalidade : null;
        this.naturalidade = naturalidade ? naturalidade : null;
        this.naturalidadeUf = naturalidadeUf ? naturalidadeUf : null;
        this.grauInstrucao = grauInstrucao ? grauInstrucao : null;
        this.profissao = profissao ? profissao : null;
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
        this.licencaCapacitacao = licencaCapacitacao ? licencaCapacitacao : null;
        this.cepEntLivro = cepEntLivro ? cepEntLivro : null;
        this.logradouroEntLivro = logradouroEntLivro ? logradouroEntLivro : null;
        this.numeroEntLivro = numeroEntLivro ? numeroEntLivro : null;
        this.complementoEntLivro = complementoEntLivro ? complementoEntLivro : null;
        this.bairroEntLivro = bairroEntLivro ? bairroEntLivro : null;
        this.cidadeEntLivro = cidadeEntLivro ? cidadeEntLivro : null;
        this.observacaoEntLivro = observacaoEntLivro ? observacaoEntLivro : null;
        this.ufEntLivro = ufEntLivro ? ufEntLivro : null;
        this.corRaca = corRaca ? corRaca : null;

        this.tipoUsuario = tipoUsuario ? tipoUsuario : null;
    }
}
