import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';

@Component({
    selector: 'jhi-tipo-advogado-detail',
    templateUrl: './tipo-advogado-detail.component.html'
})
export class TipoAdvogadoDetailComponent implements OnInit {
    tipoAdvogado: ITipoAdvogado;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoAdvogado }) => {
            this.tipoAdvogado = tipoAdvogado;
        });
    }

    previousState() {
        window.history.back();
    }
}
