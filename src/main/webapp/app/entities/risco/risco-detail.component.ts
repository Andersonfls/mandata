import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRisco } from 'app/shared/model/risco.model';

@Component({
    selector: 'jhi-risco-detail',
    templateUrl: './risco-detail.component.html'
})
export class RiscoDetailComponent implements OnInit {
    risco: IRisco;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ risco }) => {
            this.risco = risco;
        });
    }

    previousState() {
        window.history.back();
    }
}
