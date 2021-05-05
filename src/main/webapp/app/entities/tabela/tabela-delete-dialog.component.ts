import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITabela } from 'app/shared/model/tabela.model';
import { TabelaService } from './tabela.service';

@Component({
    selector: 'jhi-tabela-delete-dialog',
    templateUrl: './tabela-delete-dialog.component.html'
})
export class TabelaDeleteDialogComponent {
    tabela: ITabela;

    constructor(protected tabelaService: TabelaService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tabelaService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tabelaListModification',
                content: 'Deleted an tabela'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tabela-delete-popup',
    template: ''
})
export class TabelaDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tabela }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TabelaDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.tabela = tabela;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tabela', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tabela', { outlets: { popup: null } }]);
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
