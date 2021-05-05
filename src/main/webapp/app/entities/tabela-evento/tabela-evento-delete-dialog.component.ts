import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';
import { TabelaEventoService } from './tabela-evento.service';

@Component({
    selector: 'jhi-tabela-evento-delete-dialog',
    templateUrl: './tabela-evento-delete-dialog.component.html'
})
export class TabelaEventoDeleteDialogComponent {
    tabelaEvento: ITabelaEvento;

    constructor(
        protected tabelaEventoService: TabelaEventoService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tabelaEventoService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tabelaEventoListModification',
                content: 'Deleted an tabelaEvento'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tabela-evento-delete-popup',
    template: ''
})
export class TabelaEventoDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tabelaEvento }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TabelaEventoDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.tabelaEvento = tabelaEvento;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tabela-evento', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tabela-evento', { outlets: { popup: null } }]);
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
