import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';

type EntityResponseType = HttpResponse<ITabelaEvento>;
type EntityArrayResponseType = HttpResponse<ITabelaEvento[]>;

@Injectable({ providedIn: 'root' })
export class TabelaEventoService {
    public resourceUrl = SERVER_API_URL + 'api/tabela-eventos';

    constructor(protected http: HttpClient) {}

    create(tabelaEvento: ITabelaEvento): Observable<EntityResponseType> {
        return this.http.post<ITabelaEvento>(this.resourceUrl, tabelaEvento, { observe: 'response' });
    }

    update(tabelaEvento: ITabelaEvento): Observable<EntityResponseType> {
        return this.http.put<ITabelaEvento>(this.resourceUrl, tabelaEvento, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITabelaEvento>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITabelaEvento[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
