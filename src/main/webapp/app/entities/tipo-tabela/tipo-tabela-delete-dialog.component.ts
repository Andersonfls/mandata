import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';
import { TipoTabelaService } from './tipo-tabela.service';

@Component({
    selector: 'jhi-tipo-tabela-delete-dialog',
    templateUrl: './tipo-tabela-delete-dialog.component.html'
})
export class TipoTabelaDeleteDialogComponent {
    tipoTabela: ITipoTabela;

    constructor(
        protected tipoTabelaService: TipoTabelaService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tipoTabelaService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tipoTabelaListModification',
                content: 'Deleted an tipoTabela'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tipo-tabela-delete-popup',
    template: ''
})
export class TipoTabelaDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoTabela }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TipoTabelaDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.tipoTabela = tipoTabela;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tipo-tabela', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tipo-tabela', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
