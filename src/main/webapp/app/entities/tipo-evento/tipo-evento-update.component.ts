import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITipoEvento } from 'app/shared/model/tipo-evento.model';
import { TipoEventoService } from './tipo-evento.service';

@Component({
    selector: 'jhi-tipo-evento-update',
    templateUrl: './tipo-evento-update.component.html'
})
export class TipoEventoUpdateComponent implements OnInit {
    tipoEvento: ITipoEvento;
    isSaving: boolean;

    constructor(protected tipoEventoService: TipoEventoService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tipoEvento }) => {
            this.tipoEvento = tipoEvento;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tipoEvento.id !== undefined) {
            this.subscribeToSaveResponse(this.tipoEventoService.update(this.tipoEvento));
        } else {
            this.subscribeToSaveResponse(this.tipoEventoService.create(this.tipoEvento));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITipoEvento>>) {
        result.subscribe((res: HttpResponse<ITipoEvento>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
