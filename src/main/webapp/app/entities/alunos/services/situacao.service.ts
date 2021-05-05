import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';

@Injectable({ providedIn: 'root' })
export class SituacaoService {
    public resourceUrl = SERVER_API_URL + 'api/situacoes';
    public resourceUrlMatricula = SERVER_API_URL + 'api/situacoes/matriculas';

    constructor(protected http: HttpClient) {}

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
