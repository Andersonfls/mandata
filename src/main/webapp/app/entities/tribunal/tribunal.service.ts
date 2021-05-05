import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITribunal } from 'app/shared/model/tribunal.model';

type EntityResponseType = HttpResponse<ITribunal>;
type EntityArrayResponseType = HttpResponse<ITribunal[]>;

@Injectable({ providedIn: 'root' })
export class TribunalService {
    public resourceUrl = SERVER_API_URL + 'api/tribunals';

    constructor(protected http: HttpClient) {}

    create(tribunal: ITribunal): Observable<EntityResponseType> {
        return this.http.post<ITribunal>(this.resourceUrl, tribunal, { observe: 'response' });
    }

    update(tribunal: ITribunal): Observable<EntityResponseType> {
        return this.http.put<ITribunal>(this.resourceUrl, tribunal, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITribunal>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITribunal[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
