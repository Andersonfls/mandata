import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { IEscritorio } from 'app/shared/model/escritorio.model';
import { EscritorioService } from './escritorio.service';

@Component({
    selector: 'jhi-escritorio-update',
    templateUrl: './escritorio-update.component.html'
})
export class EscritorioUpdateComponent implements OnInit {
    escritorio: IEscritorio;
    isSaving: boolean;

    constructor(protected escritorioService: EscritorioService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ escritorio }) => {
            this.escritorio = escritorio;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.escritorio.id !== undefined) {
            this.subscribeToSaveResponse(this.escritorioService.update(this.escritorio));
        } else {
            this.subscribeToSaveResponse(this.escritorioService.create(this.escritorio));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IEscritorio>>) {
        result.subscribe((res: HttpResponse<IEscritorio>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
