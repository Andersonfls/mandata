import { IAdvogado } from 'app/shared/model/advogado.model';

export interface ITipoAdvogado {
    id?: number;
    descricao?: string;
    status?: boolean;
}

export class TipoAdvogado implements ITipoAdvogado {
    constructor(public id?: number, public descricao?: string, public status?: boolean, public tipoAdvogados?: IAdvogado[]) {
        this.status = this.status || false;
    }
}
