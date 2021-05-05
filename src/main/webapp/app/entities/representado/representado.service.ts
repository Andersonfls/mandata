import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRepresentado } from 'app/shared/model/representado.model';

type EntityResponseType = HttpResponse<IRepresentado>;
type EntityArrayResponseType = HttpResponse<IRepresentado[]>;

@Injectable({ providedIn: 'root' })
export class RepresentadoService {
    public resourceUrl = SERVER_API_URL + 'api/representados';

    constructor(protected http: HttpClient) {}

    create(representado: IRepresentado): Observable<EntityResponseType> {
        return this.http.post<IRepresentado>(this.resourceUrl, representado, { observe: 'response' });
    }

    update(representado: IRepresentado): Observable<EntityResponseType> {
        return this.http.put<IRepresentado>(this.resourceUrl, representado, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRepresentado>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRepresentado[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
