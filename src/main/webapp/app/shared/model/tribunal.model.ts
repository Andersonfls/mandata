export interface ITribunal {
    id?: number;
    nome?: string;
    sigla?: string;
    status?: boolean;
}

export class Tribunal implements ITribunal {
    constructor(public id?: number, public nome?: string, public sigla?: string, public status?: boolean) {
        this.status = this.status || false;
    }
}
