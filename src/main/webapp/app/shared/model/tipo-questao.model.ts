export interface ITipoQuestao {
    id?: number;
    nome?: string;
    status?: boolean;
}

export class TipoQuestao implements ITipoQuestao {
    constructor(public id?: number, public nome?: string, public status?: boolean) {}
}
