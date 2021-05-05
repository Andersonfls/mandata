import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRisco } from 'app/shared/model/risco.model';

type EntityResponseType = HttpResponse<IRisco>;
type EntityArrayResponseType = HttpResponse<IRisco[]>;

@Injectable({ providedIn: 'root' })
export class RiscoService {
    public resourceUrl = SERVER_API_URL + 'api/riscos';

    constructor(protected http: HttpClient) {}

    create(risco: IRisco): Observable<EntityResponseType> {
        return this.http.post<IRisco>(this.resourceUrl, risco, { observe: 'response' });
    }

    update(risco: IRisco): Observable<EntityResponseType> {
        return this.http.put<IRisco>(this.resourceUrl, risco, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRisco>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRisco[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
