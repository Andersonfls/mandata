import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';

@Component({
    selector: 'jhi-tipo-tabela-detail',
    templateUrl: './tipo-tabela-detail.component.html'
})
export class TipoTabelaDetailComponent implements OnInit {
    tipoTabela: ITipoTabela;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoTabela }) => {
            this.tipoTabela = tipoTabela;
        });
    }

    previousState() {
        window.history.back();
    }
}
