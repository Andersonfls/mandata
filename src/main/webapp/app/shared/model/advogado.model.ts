import { IEscritorio } from 'app/shared/model/escritorio.model';
import { ICliente } from 'app/shared/model/cliente.model';
import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';

export interface IAdvogado {
    id?: number;
    escritorioId?: number;
    tipoAdvogadoId?: number;
    clienteId?: number;
    nome?: string;
    oab?: string;
    oabUf?: string;
    email?: string;
    telefone?: string;
    status?: boolean;
    escritorio?: IEscritorio;
    cliente?: ICliente;
    tipoAdvogado?: ITipoAdvogado;
}

export class Advogado implements IAdvogado {
    constructor(
        public id?: number,
        public escritorioId?: number,
        public tipoAdvogadoId?: number,
        public clienteId?: number,
        public nome?: string,
        public oab?: string,
        public oabUf?: string,
        public email?: string,
        public telefone?: string,
        public status?: boolean,
        public escritorio?: IEscritorio,
        public cliente?: ICliente,
        public tipoAdvogado?: ITipoAdvogado
    ) {
        this.status = this.status || false;
        this.escritorio = this.escritorio || null;
        this.tipoAdvogado = this.tipoAdvogado || null;
    }
}
