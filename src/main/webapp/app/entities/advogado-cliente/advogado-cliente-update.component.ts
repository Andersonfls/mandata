import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';
import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';
import { AdvogadoClienteService } from './advogado-cliente.service';
import { IUser, UserService } from 'app/core';
import { IAdvogado } from 'app/shared/model/advogado.model';
import { AdvogadoService } from 'app/entities/advogado';

@Component({
    selector: 'jhi-advogado-cliente-update',
    templateUrl: './advogado-cliente-update.component.html'
})
export class AdvogadoClienteUpdateComponent implements OnInit {
    advogado_cliente: IAdvogadoCliente;
    isSaving: boolean;

    users: IUser[];

    advogados: IAdvogado[];
    data_criacaoDp: any;
    data_exclusaoDp: any;

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected advogado_clienteService: AdvogadoClienteService,
        protected userService: UserService,
        protected advogadoService: AdvogadoService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ advogado_cliente }) => {
            this.advogado_cliente = advogado_cliente;
        });
        this.userService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IUser[]>) => mayBeOk.ok),
                map((response: HttpResponse<IUser[]>) => response.body)
            )
            .subscribe((res: IUser[]) => (this.users = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.advogadoService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IAdvogado[]>) => mayBeOk.ok),
                map((response: HttpResponse<IAdvogado[]>) => response.body)
            )
            .subscribe((res: IAdvogado[]) => (this.advogados = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.advogado_cliente.id !== undefined) {
            this.subscribeToSaveResponse(this.advogado_clienteService.update(this.advogado_cliente));
        } else {
            this.subscribeToSaveResponse(this.advogado_clienteService.create(this.advogado_cliente));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IAdvogadoCliente>>) {
        result.subscribe((res: HttpResponse<IAdvogadoCliente>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackUserById(index: number, item: IUser) {
        return item.id;
    }

    trackAdvogadoById(index: number, item: IAdvogado) {
        return item.id;
    }
}
