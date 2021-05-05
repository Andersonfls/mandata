import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IEscritorio } from 'app/shared/model/escritorio.model';

type EntityResponseType = HttpResponse<IEscritorio>;
type EntityArrayResponseType = HttpResponse<IEscritorio[]>;

@Injectable({ providedIn: 'root' })
export class EscritorioService {
    public resourceUrl = SERVER_API_URL + 'api/escritorios';

    constructor(protected http: HttpClient) {}

    create(escritorio: IEscritorio): Observable<EntityResponseType> {
        return this.http.post<IEscritorio>(this.resourceUrl, escritorio, { observe: 'response' });
    }

    update(escritorio: IEscritorio): Observable<EntityResponseType> {
        return this.http.put<IEscritorio>(this.resourceUrl, escritorio, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IEscritorio>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IEscritorio[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
