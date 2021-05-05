import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class ProvaAlunoService {
    public resourceUrl = SERVER_API_URL + 'api/provas-alunos';
    public resourceUrlProvas = SERVER_API_URL + 'api/provas';

    constructor(protected http: HttpClient) {}

    // create(prova: IProvaAluno): Observable<EntityResponseType> {
    //     return this.http.post<ISituacao>(this.resourceUrl, prova, { observe: 'response' });
    // }
    //
    // update(prova: IProvaAluno): Observable<EntityResponseType> {
    //     return this.http.put<IProvaAluno>(this.resourceUrl, prova, { observe: 'response' });
    // }
    //
    // find(id: number): Observable<EntityResponseType> {
    //     return this.http.get<IProvaAluno>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    // }
    //
    // query(req?: any): Observable<EntityArrayResponseType> {
    //     const options = createRequestOption(req);
    //     return this.http.get<IProvaAluno[]>(this.resourceUrl, { params: options, observe: 'response' });
    // }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
