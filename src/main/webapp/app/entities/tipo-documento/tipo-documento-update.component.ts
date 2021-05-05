import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITipoDocumento } from 'app/shared/model/tipo-documento.model';
import { TipoDocumentoService } from './tipo-documento.service';

@Component({
    selector: 'jhi-tipo-documento-update',
    templateUrl: './tipo-documento-update.component.html'
})
export class TipoDocumentoUpdateComponent implements OnInit {
    tipoDocumento: ITipoDocumento;
    isSaving: boolean;

    constructor(protected tipoDocumentoService: TipoDocumentoService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tipoDocumento }) => {
            this.tipoDocumento = tipoDocumento;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tipoDocumento.id !== undefined) {
            this.subscribeToSaveResponse(this.tipoDocumentoService.update(this.tipoDocumento));
        } else {
            this.subscribeToSaveResponse(this.tipoDocumentoService.create(this.tipoDocumento));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITipoDocumento>>) {
        result.subscribe((res: HttpResponse<ITipoDocumento>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
