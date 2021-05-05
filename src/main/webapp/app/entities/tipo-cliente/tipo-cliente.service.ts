import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';

type EntityResponseType = HttpResponse<ITipoCliente>;
type EntityArrayResponseType = HttpResponse<ITipoCliente[]>;

@Injectable({ providedIn: 'root' })
export class TipoClienteService {
    public resourceUrl = SERVER_API_URL + 'api/tipo-clientes';

    constructor(protected http: HttpClient) {}

    create(tipoCliente: ITipoCliente): Observable<EntityResponseType> {
        return this.http.post<ITipoCliente>(this.resourceUrl, tipoCliente, { observe: 'response' });
    }

    update(tipoCliente: ITipoCliente): Observable<EntityResponseType> {
        return this.http.put<ITipoCliente>(this.resourceUrl, tipoCliente, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITipoCliente>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITipoCliente[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
