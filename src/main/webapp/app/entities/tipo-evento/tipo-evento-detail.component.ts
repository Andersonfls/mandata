import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITipoEvento } from 'app/shared/model/tipo-evento.model';

@Component({
    selector: 'jhi-tipo-evento-detail',
    templateUrl: './tipo-evento-detail.component.html'
})
export class TipoEventoDetailComponent implements OnInit {
    tipoEvento: ITipoEvento;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoEvento }) => {
            this.tipoEvento = tipoEvento;
        });
    }

    previousState() {
        window.history.back();
    }
}
