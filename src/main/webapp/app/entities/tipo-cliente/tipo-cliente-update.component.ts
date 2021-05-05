import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';
import { TipoClienteService } from './tipo-cliente.service';

@Component({
    selector: 'jhi-tipo-cliente-update',
    templateUrl: './tipo-cliente-update.component.html'
})
export class TipoClienteUpdateComponent implements OnInit {
    tipoCliente: ITipoCliente;
    isSaving: boolean;

    constructor(protected tipoClienteService: TipoClienteService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tipoCliente }) => {
            this.tipoCliente = tipoCliente;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tipoCliente.id !== undefined) {
            this.subscribeToSaveResponse(this.tipoClienteService.update(this.tipoCliente));
        } else {
            this.subscribeToSaveResponse(this.tipoClienteService.create(this.tipoCliente));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITipoCliente>>) {
        result.subscribe((res: HttpResponse<ITipoCliente>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
