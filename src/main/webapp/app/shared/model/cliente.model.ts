import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';
import { IEscritorio } from 'app/shared/model/escritorio.model';
import { IRepresentado } from 'app/shared/model/representado.model';
import { IAdvogado } from 'app/shared/model/advogado.model';

export interface ICliente {
    id?: number;
    cnpj?: string;
    cpf?: string;
    logradouro?: string;
    numero?: string;
    complemento?: string;
    bairro?: string;
    cidade?: string;
    uf?: string;
    cep?: string;
    email?: string;
    foneFixo?: string;
    foneCel?: string;
    status?: boolean;
    tipoCliente?: ITipoCliente;
    escritorio?: IEscritorio;
    representados?: IRepresentado[];
    advogados?: IAdvogado[];
    name?: string;
}

export class Cliente implements ICliente {
    constructor(
        public id?: number,
        public cnpj?: string,
        public cpf?: string,
        public logradouro?: string,
        public numero?: string,
        public complemento?: string,
        public bairro?: string,
        public cidade?: string,
        public uf?: string,
        public cep?: string,
        public email?: string,
        public foneFixo?: string,
        public foneCel?: string,
        public status?: boolean,
        public tipoCliente?: ITipoCliente,
        public escritorio?: IEscritorio,
        public representados?: IRepresentado[],
        public advogados?: IAdvogado[],
        public name?: string
    ) {
        this.status = this.status || false;
    }
}
