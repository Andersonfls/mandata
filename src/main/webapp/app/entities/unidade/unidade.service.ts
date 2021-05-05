import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IUnidade } from 'app/shared/model/unidade.model';

type EntityResponseType = HttpResponse<IUnidade>;
type EntityArrayResponseType = HttpResponse<IUnidade[]>;

@Injectable({ providedIn: 'root' })
export class UnidadeService {
    public resourceUrl = SERVER_API_URL + 'api/unidades';

    constructor(protected http: HttpClient) {}

    create(unidade: IUnidade): Observable<EntityResponseType> {
        return this.http.post<IUnidade>(this.resourceUrl, unidade, { observe: 'response' });
    }

    update(unidade: IUnidade): Observable<EntityResponseType> {
        return this.http.put<IUnidade>(this.resourceUrl, unidade, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IUnidade>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IUnidade[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
