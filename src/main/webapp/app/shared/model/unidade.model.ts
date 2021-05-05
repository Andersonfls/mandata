import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';

export interface IUnidade {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class Unidade implements IUnidade {
    constructor(public id?: number, public descricao?: string, public status?: boolean, public unidades?: ITabelaEvento[]) {
        this.status = this.status || false;
    }
}
