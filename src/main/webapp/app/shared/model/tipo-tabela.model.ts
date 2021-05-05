import { ITabela } from 'app/shared/model/tabela.model';

export interface ITipoTabela {
    id?: number;
    descricao?: string;
}

export class TipoTabela implements ITipoTabela {
    constructor(public id?: number, public descricao?: string, public tipoTabelas?: ITabela[]) {}
}
