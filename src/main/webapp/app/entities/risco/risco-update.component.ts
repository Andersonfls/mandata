import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { IRisco } from 'app/shared/model/risco.model';
import { RiscoService } from './risco.service';

@Component({
    selector: 'jhi-risco-update',
    templateUrl: './risco-update.component.html'
})
export class RiscoUpdateComponent implements OnInit {
    risco: IRisco;
    isSaving: boolean;

    constructor(protected riscoService: RiscoService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ risco }) => {
            this.risco = risco;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.risco.id !== undefined) {
            this.subscribeToSaveResponse(this.riscoService.update(this.risco));
        } else {
            this.subscribeToSaveResponse(this.riscoService.create(this.risco));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IRisco>>) {
        result.subscribe((res: HttpResponse<IRisco>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
