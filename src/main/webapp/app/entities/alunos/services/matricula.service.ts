import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';


@Injectable({ providedIn: 'root' })
export class MatriculaService {
    public resourceUrl = SERVER_API_URL + 'api/matriculas';

    constructor(protected http: HttpClient) {}

    // create(matricula: IMatricula): Observable<EntityResponseType> {
    //     return this.http.post<IMatricula>(this.resourceUrl, matricula, { observe: 'response' });
    // }
    //
    // update(matricula: IMatricula): Observable<EntityResponseType> {
    //     return this.http.put<IMatricula>(this.resourceUrl, matricula, { observe: 'response' });
    // }
    //
    // find(id: number): Observable<EntityResponseType> {
    //     return this.http.get<IMatricula>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    // }
    //
    // findMatriculaAluno(idAluno: number): Observable<EntityResponseType> {
    //     return this.http.get<IMatricula>(`${this.resourceUrl + '/aluno'}/${idAluno}`, { observe: 'response' });
    // }
    //
    // query(req?: any): Observable<EntityArrayResponseType> {
    //     const options = createRequestOption(req);
    //     return this.http.get<IMatricula[]>(this.resourceUrl, { params: options, observe: 'response' });
    // }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
