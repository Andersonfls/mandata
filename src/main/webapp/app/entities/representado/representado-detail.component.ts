import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRepresentado } from 'app/shared/model/representado.model';

@Component({
    selector: 'jhi-representado-detail',
    templateUrl: './representado-detail.component.html'
})
export class RepresentadoDetailComponent implements OnInit {
    representado: IRepresentado;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ representado }) => {
            this.representado = representado;
        });
    }

    previousState() {
        window.history.back();
    }
}
