import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';

@Component({
    selector: 'jhi-tipo-cliente-detail',
    templateUrl: './tipo-cliente-detail.component.html'
})
export class TipoClienteDetailComponent implements OnInit {
    tipoCliente: ITipoCliente;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoCliente }) => {
            this.tipoCliente = tipoCliente;
        });
    }

    previousState() {
        window.history.back();
    }
}
