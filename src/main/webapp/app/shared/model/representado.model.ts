import { ICliente } from 'app/shared/model/cliente.model';

export interface IRepresentado {
    id?: number;
    nome?: string;
    contato?: string;
    email?: string;
    foneFixo?: string;
    foneCel?: string;
    status?: boolean;
    cliente?: ICliente;
}

export class Representado implements IRepresentado {
    constructor(
        public id?: number,
        public nome?: string,
        public contato?: string,
        public email?: string,
        public foneFixo?: string,
        public foneCel?: string,
        public status?: boolean,
        public cliente?: ICliente
    ) {
        this.status = this.status || false;
    }
}
