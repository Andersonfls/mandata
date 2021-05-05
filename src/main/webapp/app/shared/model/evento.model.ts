import { ITipoEvento } from 'app/shared/model/tipo-evento.model';

export interface IEvento {
    id?: number;
    descricao?: string;
    status?: boolean;
    tipoEvento?: ITipoEvento;
}

export class Evento implements IEvento {
    constructor(
        public id?: number,
        public descricao?: string,
        public status?: boolean,
        public tipoEvento?: ITipoEvento,
    ) {
        this.status = this.status || false;
    }
}
