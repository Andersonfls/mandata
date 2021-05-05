import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';
import {IAdvogado} from 'app/shared/model/advogado.model';

type EntityResponseType = HttpResponse<IAdvogadoCliente>;
type EntityArrayResponseType = HttpResponse<IAdvogadoCliente[]>;

@Injectable({ providedIn: 'root' })
export class AdvogadoClienteService {
    public resourceUrl = SERVER_API_URL + 'api/advogado-clientes';

    constructor(protected http: HttpClient) {}

    create(advogado_cliente: IAdvogadoCliente): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(advogado_cliente);
        return this.http
            .post<IAdvogadoCliente>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(advogado_cliente: IAdvogadoCliente): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(advogado_cliente);
        return this.http
            .put<IAdvogadoCliente>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAdvogadoCliente>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    findAdvogadosPorClienteId(id: number): Observable<EntityArrayResponseType> {
        const options = createRequestOption(null);
        return this.http.get<IAdvogado[]>(`${this.resourceUrl}/cliente/${id}`, { params: options, observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAdvogadoCliente[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    deleteByClienteId(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/clientes/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(advogado_cliente: IAdvogadoCliente): IAdvogadoCliente {
        const copy: IAdvogadoCliente = Object.assign({}, advogado_cliente, {
            data_criacao:
                advogado_cliente.data_criacao != null && advogado_cliente.data_criacao.isValid()
                    ? advogado_cliente.data_criacao.format(DATE_FORMAT)
                    : null,
            data_exclusao:
                advogado_cliente.data_exclusao != null && advogado_cliente.data_exclusao.isValid()
                    ? advogado_cliente.data_exclusao.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.data_criacao = res.body.data_criacao != null ? moment(res.body.data_criacao) : null;
            res.body.data_exclusao = res.body.data_exclusao != null ? moment(res.body.data_exclusao) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((advogado_cliente: IAdvogadoCliente) => {
                advogado_cliente.data_criacao = advogado_cliente.data_criacao != null ? moment(advogado_cliente.data_criacao) : null;
                advogado_cliente.data_exclusao = advogado_cliente.data_exclusao != null ? moment(advogado_cliente.data_exclusao) : null;
            });
        }
        return res;
    }
}
