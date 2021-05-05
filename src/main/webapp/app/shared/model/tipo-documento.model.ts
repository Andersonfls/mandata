export interface ITipoDocumento {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class TipoDocumento implements ITipoDocumento {
    constructor(public id?: number, public descricao?: string, public status?: boolean) {
        this.status = this.status || false;
    }
}
