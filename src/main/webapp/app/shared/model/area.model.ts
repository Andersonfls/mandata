export interface IArea {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class Area implements IArea {
    constructor(public id?: number, public descricao?: string, public status?: boolean) {
        this.status = this.status || false;
    }
}
