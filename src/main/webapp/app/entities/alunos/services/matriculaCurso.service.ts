import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';

@Injectable({ providedIn: 'root' })
export class MatriculaCursoService {
    public resourceUrl = SERVER_API_URL + 'api/matriculas-cursos';

    constructor(protected http: HttpClient) {}

    // create(matricula: IMatriculaCurso): Observable<EntityResponseType> {
    //     return this.http.post<IMatriculaCurso>(this.resourceUrl, matricula, { observe: 'response' });
    // }
    //
    // update(matricula: IMatriculaCurso): Observable<EntityResponseType> {
    //     return this.http.put<IMatriculaCurso>(this.resourceUrl, matricula, { observe: 'response' });
    // }
    //
    // find(id: number): Observable<EntityResponseType> {
    //     return this.http.get<IMatriculaCurso>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    // }
    //
    // findAllByAluno(alunoId: number): Observable<EntityArrayResponseType> {
    //     return this.http.get<IMatriculaCurso[]>(`${this.resourceUrl}/aluno/${alunoId}`, { observe: 'response' });
    // }
    //
    // query(req?: any): Observable<EntityArrayResponseType> {
    //     const options = createRequestOption(req);
    //     return this.http.get<IMatriculaCurso[]>(this.resourceUrl, { params: options, observe: 'response' });
    // }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
