import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IUnidade } from 'app/shared/model/unidade.model';
import { UnidadeService } from './unidade.service';

@Component({
    selector: 'jhi-unidade-delete-dialog',
    templateUrl: './unidade-delete-dialog.component.html'
})
export class UnidadeDeleteDialogComponent {
    unidade: IUnidade;

    constructor(protected unidadeService: UnidadeService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.unidadeService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'unidadeListModification',
                content: 'Deleted an unidade'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-unidade-delete-popup',
    template: ''
})
export class UnidadeDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ unidade }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(UnidadeDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.unidade = unidade;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/unidade', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/unidade', { outlets: { popup: null } }]);
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
