import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';

type EntityResponseType = HttpResponse<ITipoAdvogado>;
type EntityArrayResponseType = HttpResponse<ITipoAdvogado[]>;

@Injectable({ providedIn: 'root' })
export class TipoAdvogadoService {
    public resourceUrl = SERVER_API_URL + 'api/tipo-advogados';

    constructor(protected http: HttpClient) {}

    create(tipoAdvogado: ITipoAdvogado): Observable<EntityResponseType> {
        return this.http.post<ITipoAdvogado>(this.resourceUrl, tipoAdvogado, { observe: 'response' });
    }

    update(tipoAdvogado: ITipoAdvogado): Observable<EntityResponseType> {
        return this.http.put<ITipoAdvogado>(this.resourceUrl, tipoAdvogado, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITipoAdvogado>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITipoAdvogado[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
