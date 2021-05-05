import { Moment } from 'moment';
import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';

export interface ITabela {
    id?: number;
    descricao?: string;
    clienteId?: number;
    dataCriacao?: Moment;
    atual?: boolean;
    status?: boolean;
    tipoTabela?: ITipoTabela;
}

export class Tabela implements ITabela {
    constructor(
        public id?: number,
        public descricao?: string,
        public clienteId?: number,
        public dataCriacao?: Moment,
        public atual?: boolean,
        public status?: boolean,
        public tipoTabela?: ITipoTabela,
    ) {
        this.atual = this.atual || false;
        this.status = this.status || false;
    }
}
