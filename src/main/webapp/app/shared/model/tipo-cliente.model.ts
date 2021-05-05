import { ICliente } from 'app/shared/model/cliente.model';

export interface ITipoCliente {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class TipoCliente implements ITipoCliente {
    constructor(public id?: number, public descricao?: string, public status?: boolean, public tipoClientes?: ICliente[]) {
        this.status = this.status || false;
    }
}
