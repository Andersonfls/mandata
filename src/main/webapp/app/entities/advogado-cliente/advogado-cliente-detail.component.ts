import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';

@Component({
    selector: 'jhi-advogado-cliente-detail',
    templateUrl: './advogado-cliente-detail.component.html'
})
export class AdvogadoClienteDetailComponent implements OnInit {
    advogado_cliente: IAdvogadoCliente;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ advogado_cliente }) => {
            this.advogado_cliente = advogado_cliente;
        });
    }

    previousState() {
        window.history.back();
    }
}
