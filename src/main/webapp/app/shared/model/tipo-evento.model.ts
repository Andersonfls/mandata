import { IEvento } from 'app/shared/model/evento.model';

export interface ITipoEvento {
    id?: number;
    descricao?: string;
}

export class TipoEvento implements ITipoEvento {
    constructor(public id?: number, public descricao?: string, public tabelaEventos?: IEvento[]) {}
}
