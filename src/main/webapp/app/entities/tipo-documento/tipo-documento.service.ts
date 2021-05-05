import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITipoDocumento } from 'app/shared/model/tipo-documento.model';

type EntityResponseType = HttpResponse<ITipoDocumento>;
type EntityArrayResponseType = HttpResponse<ITipoDocumento[]>;

@Injectable({ providedIn: 'root' })
export class TipoDocumentoService {
    public resourceUrl = SERVER_API_URL + 'api/tipo-documentos';

    constructor(protected http: HttpClient) {}

    create(tipoDocumento: ITipoDocumento): Observable<EntityResponseType> {
        return this.http.post<ITipoDocumento>(this.resourceUrl, tipoDocumento, { observe: 'response' });
    }

    update(tipoDocumento: ITipoDocumento): Observable<EntityResponseType> {
        return this.http.put<ITipoDocumento>(this.resourceUrl, tipoDocumento, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITipoDocumento>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITipoDocumento[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
