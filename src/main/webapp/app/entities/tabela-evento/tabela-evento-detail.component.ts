import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';

@Component({
    selector: 'jhi-tabela-evento-detail',
    templateUrl: './tabela-evento-detail.component.html'
})
export class TabelaEventoDetailComponent implements OnInit {
    tabelaEvento: ITabelaEvento;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tabelaEvento }) => {
            this.tabelaEvento = tabelaEvento;
        });
    }

    previousState() {
        window.history.back();
    }
}
