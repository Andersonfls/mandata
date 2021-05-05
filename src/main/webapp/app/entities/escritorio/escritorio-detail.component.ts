import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IEscritorio } from 'app/shared/model/escritorio.model';

@Component({
    selector: 'jhi-escritorio-detail',
    templateUrl: './escritorio-detail.component.html'
})
export class EscritorioDetailComponent implements OnInit {
    escritorio: IEscritorio;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ escritorio }) => {
            this.escritorio = escritorio;
        });
    }

    previousState() {
        window.history.back();
    }
}
