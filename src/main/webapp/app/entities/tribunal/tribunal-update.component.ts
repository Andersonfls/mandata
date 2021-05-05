import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITribunal } from 'app/shared/model/tribunal.model';
import { TribunalService } from './tribunal.service';

@Component({
    selector: 'jhi-tribunal-update',
    templateUrl: './tribunal-update.component.html'
})
export class TribunalUpdateComponent implements OnInit {
    tribunal: ITribunal;
    isSaving: boolean;

    constructor(protected tribunalService: TribunalService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tribunal }) => {
            this.tribunal = tribunal;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tribunal.id !== undefined) {
            this.subscribeToSaveResponse(this.tribunalService.update(this.tribunal));
        } else {
            this.subscribeToSaveResponse(this.tribunalService.create(this.tribunal));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITribunal>>) {
        result.subscribe((res: HttpResponse<ITribunal>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
