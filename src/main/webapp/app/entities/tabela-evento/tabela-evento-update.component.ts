import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';
import { TabelaEventoService } from './tabela-evento.service';
import { IEvento } from 'app/shared/model/evento.model';
import { EventoService } from 'app/entities/evento';
import { IUnidade } from 'app/shared/model/unidade.model';
import { UnidadeService } from 'app/entities/unidade';
import { ITabela } from 'app/shared/model/tabela.model';
import { TabelaService } from 'app/entities/tabela';

@Component({
    selector: 'jhi-tabela-evento-update',
    templateUrl: './tabela-evento-update.component.html'
})
export class TabelaEventoUpdateComponent implements OnInit {
    tabelaEvento: ITabelaEvento;
    isSaving: boolean;

    eventos: IEvento[];

    unidades: IUnidade[];

    tabelas: ITabela[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected tabelaEventoService: TabelaEventoService,
        protected eventoService: EventoService,
        protected unidadeService: UnidadeService,
        protected tabelaService: TabelaService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tabelaEvento }) => {
            this.tabelaEvento = tabelaEvento;
        });
        this.eventoService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IEvento[]>) => mayBeOk.ok),
                map((response: HttpResponse<IEvento[]>) => response.body)
            )
            .subscribe((res: IEvento[]) => (this.eventos = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.unidadeService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IUnidade[]>) => mayBeOk.ok),
                map((response: HttpResponse<IUnidade[]>) => response.body)
            )
            .subscribe((res: IUnidade[]) => (this.unidades = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.tabelaService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ITabela[]>) => mayBeOk.ok),
                map((response: HttpResponse<ITabela[]>) => response.body)
            )
            .subscribe((res: ITabela[]) => (this.tabelas = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tabelaEvento.id !== undefined) {
            this.subscribeToSaveResponse(this.tabelaEventoService.update(this.tabelaEvento));
        } else {
            this.subscribeToSaveResponse(this.tabelaEventoService.create(this.tabelaEvento));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITabelaEvento>>) {
        result.subscribe((res: HttpResponse<ITabelaEvento>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackEventoById(index: number, item: IEvento) {
        return item.id;
    }

    trackUnidadeById(index: number, item: IUnidade) {
        return item.id;
    }

    trackTabelaById(index: number, item: ITabela) {
        return item.id;
    }
}
