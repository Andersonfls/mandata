import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';
import { TipoTabelaService } from './tipo-tabela.service';

@Component({
    selector: 'jhi-tipo-tabela-update',
    templateUrl: './tipo-tabela-update.component.html'
})
export class TipoTabelaUpdateComponent implements OnInit {
    tipoTabela: ITipoTabela;
    isSaving: boolean;

    constructor(protected tipoTabelaService: TipoTabelaService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tipoTabela }) => {
            this.tipoTabela = tipoTabela;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tipoTabela.id !== undefined) {
            this.subscribeToSaveResponse(this.tipoTabelaService.update(this.tipoTabela));
        } else {
            this.subscribeToSaveResponse(this.tipoTabelaService.create(this.tipoTabela));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITipoTabela>>) {
        result.subscribe((res: HttpResponse<ITipoTabela>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
