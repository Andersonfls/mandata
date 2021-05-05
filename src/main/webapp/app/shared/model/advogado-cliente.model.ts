import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';
import { IAdvogado } from 'app/shared/model/advogado.model';

export interface IAdvogadoCliente {
    id?: number;
    data_criacao?: Moment;
    data_exclusao?: Moment;
    status?: boolean;
    cliente?: IUser;
    advogado?: IAdvogado;
}

export class AdvogadoCliente implements IAdvogadoCliente {
    constructor(
        public id?: number,
        public data_criacao?: Moment,
        public data_exclusao?: Moment,
        public status?: boolean,
        public cliente?: IUser,
        public advogado?: IAdvogado
    ) {
        this.status = this.status || false;
    }
}
