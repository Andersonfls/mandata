import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';
import { TipoAdvogadoService } from './tipo-advogado.service';

@Component({
    selector: 'jhi-tipo-advogado-update',
    templateUrl: './tipo-advogado-update.component.html'
})
export class TipoAdvogadoUpdateComponent implements OnInit {
    tipoAdvogado: ITipoAdvogado;
    isSaving: boolean;

    constructor(protected tipoAdvogadoService: TipoAdvogadoService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tipoAdvogado }) => {
            this.tipoAdvogado = tipoAdvogado;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tipoAdvogado.id !== undefined) {
            this.subscribeToSaveResponse(this.tipoAdvogadoService.update(this.tipoAdvogado));
        } else {
            this.subscribeToSaveResponse(this.tipoAdvogadoService.create(this.tipoAdvogado));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITipoAdvogado>>) {
        result.subscribe((res: HttpResponse<ITipoAdvogado>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
