import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';
import { AccountService } from 'app/core';
import { AdvogadoClienteService } from './advogado-cliente.service';

@Component({
    selector: 'jhi-advogado-cliente',
    templateUrl: './advogado-cliente.component.html'
})
export class AdvogadoClienteComponent implements OnInit, OnDestroy {
    advogado_clientes: IAdvogadoCliente[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected advogado_clienteService: AdvogadoClienteService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.advogado_clienteService
            .query()
            .pipe(
                filter((res: HttpResponse<IAdvogadoCliente[]>) => res.ok),
                map((res: HttpResponse<IAdvogadoCliente[]>) => res.body)
            )
            .subscribe(
                (res: IAdvogadoCliente[]) => {
                    this.advogado_clientes = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInAdvogado_clientes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IAdvogadoCliente) {
        return item.id;
    }

    registerChangeInAdvogado_clientes() {
        this.eventSubscriber = this.eventManager.subscribe('advogado_clienteListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
