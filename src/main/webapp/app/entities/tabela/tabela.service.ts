import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITabela } from 'app/shared/model/tabela.model';

type EntityResponseType = HttpResponse<ITabela>;
type EntityArrayResponseType = HttpResponse<ITabela[]>;

@Injectable({ providedIn: 'root' })
export class TabelaService {
    public resourceUrl = SERVER_API_URL + 'api/tabelas';

    constructor(protected http: HttpClient) {}

    create(tabela: ITabela): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(tabela);
        return this.http
            .post<ITabela>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(tabela: ITabela): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(tabela);
        return this.http
            .put<ITabela>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ITabela>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ITabela[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(tabela: ITabela): ITabela {
        const copy: ITabela = Object.assign({}, tabela, {
            dataCriacao: tabela.dataCriacao != null && tabela.dataCriacao.isValid() ? tabela.dataCriacao.format(DATE_FORMAT) : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.dataCriacao = res.body.dataCriacao != null ? moment(res.body.dataCriacao) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((tabela: ITabela) => {
                tabela.dataCriacao = tabela.dataCriacao != null ? moment(tabela.dataCriacao) : null;
            });
        }
        return res;
    }
}
