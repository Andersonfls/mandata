import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';
import { ITabela } from 'app/shared/model/tabela.model';
import { TabelaService } from './tabela.service';
import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';
import { TipoTabelaService } from 'app/entities/tipo-tabela';

@Component({
    selector: 'jhi-tabela-update',
    templateUrl: './tabela-update.component.html'
})
export class TabelaUpdateComponent implements OnInit {
    tabela: ITabela;
    isSaving: boolean;

    tipotabelas: ITipoTabela[];
    dataCriacaoDp: any;

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected tabelaService: TabelaService,
        protected tipoTabelaService: TipoTabelaService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tabela }) => {
            this.tabela = tabela;
        });
        this.tipoTabelaService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ITipoTabela[]>) => mayBeOk.ok),
                map((response: HttpResponse<ITipoTabela[]>) => response.body)
            )
            .subscribe((res: ITipoTabela[]) => (this.tipotabelas = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tabela.id !== undefined) {
            this.subscribeToSaveResponse(this.tabelaService.update(this.tabela));
        } else {
            this.subscribeToSaveResponse(this.tabelaService.create(this.tabela));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITabela>>) {
        result.subscribe((res: HttpResponse<ITabela>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackTipoTabelaById(index: number, item: ITipoTabela) {
        return item.id;
    }
}
