import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IRepresentado } from 'app/shared/model/representado.model';
import { RepresentadoService } from './representado.service';
import { ICliente } from 'app/shared/model/cliente.model';
import { ClienteService } from 'app/entities/cliente';

@Component({
    selector: 'jhi-representado-update',
    templateUrl: './representado-update.component.html'
})
export class RepresentadoUpdateComponent implements OnInit {
    representado: IRepresentado;
    isSaving: boolean;

    clientes: ICliente[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected representadoService: RepresentadoService,
        protected clienteService: ClienteService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ representado }) => {
            this.representado = representado;
        });
        this.clienteService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ICliente[]>) => mayBeOk.ok),
                map((response: HttpResponse<ICliente[]>) => response.body)
            )
            .subscribe((res: ICliente[]) => (this.clientes = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.representado.id !== undefined) {
            this.subscribeToSaveResponse(this.representadoService.update(this.representado));
        } else {
            this.subscribeToSaveResponse(this.representadoService.create(this.representado));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IRepresentado>>) {
        result.subscribe((res: HttpResponse<IRepresentado>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackClienteById(index: number, item: ICliente) {
        return item.id;
    }
}
