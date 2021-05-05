import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';

type EntityResponseType = HttpResponse<ITipoTabela>;
type EntityArrayResponseType = HttpResponse<ITipoTabela[]>;

@Injectable({ providedIn: 'root' })
export class TipoTabelaService {
    public resourceUrl = SERVER_API_URL + 'api/tipo-tabelas';

    constructor(protected http: HttpClient) {}

    create(tipoTabela: ITipoTabela): Observable<EntityResponseType> {
        return this.http.post<ITipoTabela>(this.resourceUrl, tipoTabela, { observe: 'response' });
    }

    update(tipoTabela: ITipoTabela): Observable<EntityResponseType> {
        return this.http.put<ITipoTabela>(this.resourceUrl, tipoTabela, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITipoTabela>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITipoTabela[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
