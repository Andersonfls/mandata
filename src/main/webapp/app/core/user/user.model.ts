import {ITipoCliente} from 'app/shared/model/tipo-cliente.model';
import {IEscritorio} from 'app/shared/model/escritorio.model';
import {IRepresentado} from 'app/shared/model/representado.model';
import {IAdvogado} from 'app/shared/model/advogado.model';

export interface IUser {
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

    cnpj?: string;
    cpf?: string;
    logradouro?: string;
    numero?: string;
    complemento?: string;
    bairro?: string;
    cidade?: string;
    uf?: string;
    cep?: string;
    foneFixo?: string;
    foneCel?: string;
    status?: boolean;
    tipoCliente?: ITipoCliente;
    escritorio?: IEscritorio;
    representados?: IRepresentado[];
    advogados?: IAdvogado[];
}

export class User implements IUser {
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

        public cnpj?: string,
        public cpf?: string,
        public logradouro?: string,
        public numero?: string,
        public complemento?: string,
        public bairro?: string,
        public cidade?: string,
        public uf?: string,
        public cep?: string,
        public foneFixo?: string,
        public foneCel?: string,
        public status?: boolean,
        public tipoCliente?: ITipoCliente,
        public escritorio?: IEscritorio,
        public representados?: IRepresentado[],
        public advogados?: IAdvogado[],

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

        this.tipoCliente = tipoCliente ? tipoCliente : null;
        this.escritorio = escritorio ? escritorio : null;
        this.representados = representados ? representados : null;
        this.advogados = advogados ? advogados : null;
        this.status = status ? status : false;
    }
}
