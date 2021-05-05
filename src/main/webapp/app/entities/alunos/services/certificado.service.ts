import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';

@Injectable({ providedIn: 'root' })
export class CertificadoService {
    public resourceUrl = SERVER_API_URL + 'api/certificados';

    constructor(protected http: HttpClient) {}

}
