import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITabela } from 'app/shared/model/tabela.model';

@Component({
    selector: 'jhi-tabela-detail',
    templateUrl: './tabela-detail.component.html'
})
export class TabelaDetailComponent implements OnInit {
    tabela: ITabela;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tabela }) => {
            this.tabela = tabela;
        });
    }

    previousState() {
        window.history.back();
    }
}
