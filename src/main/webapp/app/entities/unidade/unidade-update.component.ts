import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { IUnidade } from 'app/shared/model/unidade.model';
import { UnidadeService } from './unidade.service';

@Component({
    selector: 'jhi-unidade-update',
    templateUrl: './unidade-update.component.html'
})
export class UnidadeUpdateComponent implements OnInit {
    unidade: IUnidade;
    isSaving: boolean;

    constructor(protected unidadeService: UnidadeService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ unidade }) => {
            this.unidade = unidade;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.unidade.id !== undefined) {
            this.subscribeToSaveResponse(this.unidadeService.update(this.unidade));
        } else {
            this.subscribeToSaveResponse(this.unidadeService.create(this.unidade));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IUnidade>>) {
        result.subscribe((res: HttpResponse<IUnidade>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
