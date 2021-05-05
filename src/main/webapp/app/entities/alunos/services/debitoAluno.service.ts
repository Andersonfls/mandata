import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';


@Injectable({ providedIn: 'root' })
export class DebitoAlunoService {
    public resourceUrl = SERVER_API_URL + 'api/debitos-alunos';

    constructor(protected http: HttpClient) {}
    //
    // create(debitoAluno: IDebitoAluno): Observable<EntityResponseType> {
    //     return this.http.post<IDebitoAluno>(this.resourceUrl, debitoAluno, { observe: 'response' });
    // }
    //
    // update(debitoAluno: IDebitoAluno): Observable<EntityResponseType> {
    //     return this.http.put<IDebitoAluno>(this.resourceUrl, debitoAluno, { observe: 'response' });
    // }
    //
    // find(id: number): Observable<EntityResponseType> {
    //     return this.http.get<IDebitoAluno>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    // }
    //
    // findAllByAluno(alunoId: number): Observable<EntityArrayResponseType> {
    //     return this.http.get<IDebitoAluno[]>(`${this.resourceUrl}/aluno/${alunoId}`, { observe: 'response' });
    // }
    //
    // query(req?: any): Observable<EntityArrayResponseType> {
    //     const options = createRequestOption(req);
    //     return this.http.get<IDebitoAluno[]>(this.resourceUrl, { params: options, observe: 'response' });
    // }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
