export interface IRisco {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class Risco implements IRisco {
    constructor(public id?: number, public descricao?: string, public status?: boolean) {
        this.status = this.status || false;
    }
}
