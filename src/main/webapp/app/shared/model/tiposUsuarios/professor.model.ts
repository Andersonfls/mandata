
export interface IProfessor {
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

    grauInstrucao?: string;
    cpf?: string;
    sexo?: string;
    dataNascimento?: Date;
    telefone?: string;
    celular?: string;

    cep?: string;
    enderecoLogradouro?: string;
    enderecoNumero?: string;
    enderecoComplemento?: string;
    enderecoBairro?: string;
    enderecoCidade?: string;
    enderecoUf?: string;
    enderecoObservacao?: string;

    tipoUsuario?: number;
}
export class Professor implements IProfessor {
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
        public grauInstrucao?: string,
        public cpf?: string,
        public sexo?: string,
        public dataNascimento?: Date,
        public telefone?: string,
        public celular?: string,
        public cep?: string,
        public enderecoLogradouro?: string,
        public enderecoNumero?: string,
        public enderecoComplemento?: string,
        public enderecoBairro?: string,
        public enderecoCidade?: string,
        public enderecoUf?: string,
        public enderecoObservacao?: string,
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

        this.grauInstrucao = grauInstrucao ? grauInstrucao : null;
        this.cpf = cpf ? cpf : null;
        this.sexo = sexo ? sexo : null;
        this.dataNascimento = dataNascimento ? dataNascimento : null;
        this.telefone = telefone ? telefone : null;
        this.celular = celular ? celular : null;

        this.cep = cep ? cep : null;
        this.enderecoLogradouro = enderecoLogradouro ? enderecoLogradouro : null;
        this.enderecoNumero = enderecoNumero ? enderecoNumero : null;
        this.enderecoComplemento = enderecoComplemento ? enderecoComplemento : null;
        this.enderecoBairro = enderecoBairro ? enderecoBairro : null;
        this.enderecoCidade = enderecoCidade ? enderecoCidade : null;
        this.enderecoUf = enderecoUf ? enderecoUf : null;
        this.enderecoObservacao = enderecoObservacao ? enderecoObservacao : null;

        this.tipoUsuario = tipoUsuario ? tipoUsuario : null;
    }
}
