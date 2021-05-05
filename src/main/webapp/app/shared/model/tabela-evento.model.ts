import { IEvento } from 'app/shared/model/evento.model';
import { IUnidade } from 'app/shared/model/unidade.model';
import { ITabela } from 'app/shared/model/tabela.model';

export interface ITabelaEvento {
    id?: number;
    valor?: number;
    evento?: IEvento;
    unidade?: IUnidade;
    tabela?: ITabela;
}

export class TabelaEvento implements ITabelaEvento {
    constructor(
        public id?: number,
        public valor?: number,
        public evento?: IEvento,
        public unidade?: IUnidade,
        public tabela?: ITabela
    ) {}
}
