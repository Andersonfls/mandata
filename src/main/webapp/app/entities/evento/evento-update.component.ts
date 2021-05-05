import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IEvento } from 'app/shared/model/evento.model';
import { EventoService } from './evento.service';
import { ITipoEvento } from 'app/shared/model/tipo-evento.model';
import { TipoEventoService } from 'app/entities/tipo-evento';

@Component({
    selector: 'jhi-evento-update',
    templateUrl: './evento-update.component.html'
})
export class EventoUpdateComponent implements OnInit {
    evento: IEvento;
    isSaving: boolean;

    tipoeventos: ITipoEvento[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected eventoService: EventoService,
        protected tipoEventoService: TipoEventoService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ evento }) => {
            this.evento = evento;
        });
        this.tipoEventoService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ITipoEvento[]>) => mayBeOk.ok),
                map((response: HttpResponse<ITipoEvento[]>) => response.body)
            )
            .subscribe((res: ITipoEvento[]) => (this.tipoeventos = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.evento.id !== undefined) {
            this.subscribeToSaveResponse(this.eventoService.update(this.evento));
        } else {
            this.subscribeToSaveResponse(this.eventoService.create(this.evento));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IEvento>>) {
        result.subscribe((res: HttpResponse<IEvento>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackTipoEventoById(index: number, item: ITipoEvento) {
        return item.id;
    }
}
