import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITribunal } from 'app/shared/model/tribunal.model';

@Component({
    selector: 'jhi-tribunal-detail',
    templateUrl: './tribunal-detail.component.html'
})
export class TribunalDetailComponent implements OnInit {
    tribunal: ITribunal;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tribunal }) => {
            this.tribunal = tribunal;
        });
    }

    previousState() {
        window.history.back();
    }
}
