import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITipoDocumento } from 'app/shared/model/tipo-documento.model';

@Component({
    selector: 'jhi-tipo-documento-detail',
    templateUrl: './tipo-documento-detail.component.html'
})
export class TipoDocumentoDetailComponent implements OnInit {
    tipoDocumento: ITipoDocumento;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoDocumento }) => {
            this.tipoDocumento = tipoDocumento;
        });
    }

    previousState() {
        window.history.back();
    }
}
