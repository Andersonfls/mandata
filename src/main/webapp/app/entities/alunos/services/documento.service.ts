import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IDocumento } from 'app/shared/model/documento.model';

type EntityArrayResponseType = HttpResponse<IDocumento[]>;

@Injectable({ providedIn: 'root' })
export class DocumentoService {
    public resourceUrl = SERVER_API_URL + 'api/documentos';

    constructor(protected http: HttpClient, private httpClient: HttpClient) {}

    uploadDocumento(nomePasta: string, file: File): Observable<HttpEvent<{}>> {
        const formdata: FormData = new FormData();
        formdata.append('file', file);
        formdata.append('nomePasta', nomePasta);

        // return this.http.post<IDocumento>(`${this.resourceUrl + '/arquivos'}`, formdata, { observe: 'response', reportProgress: true });

        const req = new HttpRequest('POST', this.resourceUrl + '/arquivos', formdata, {
            reportProgress: true,
            responseType: 'text'
        });
        return this.httpClient.request(req);
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IDocumento[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    deleteArquivo(pasta: string, filename: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl + '/arquivos'}/${pasta}/${filename}`, { observe: 'response' });
    }
}
