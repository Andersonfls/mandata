import { IAdvogado } from 'app/shared/model/advogado.model';
import { ICliente } from 'app/shared/model/cliente.model';

export interface IEscritorio {
    id?: number;
    cnpj?: string;
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
    advogados?: IAdvogado[];
    clientes?: ICliente[];
}

export class Escritorio implements IEscritorio {
    constructor(
        public id?: number,
        public cnpj?: string,
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
        public advogados?: IAdvogado[],
        public clientes?: ICliente[]
    ) {
        this.status = this.status || false;
    }
}
