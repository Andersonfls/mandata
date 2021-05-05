import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRepresentado } from 'app/shared/model/representado.model';
import { RepresentadoService } from './representado.service';

@Component({
    selector: 'jhi-representado-delete-dialog',
    templateUrl: './representado-delete-dialog.component.html'
})
export class RepresentadoDeleteDialogComponent {
    representado: IRepresentado;

    constructor(
        protected representadoService: RepresentadoService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.representadoService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'representadoListModification',
                content: 'Deleted an representado'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-representado-delete-popup',
    template: ''
})
export class RepresentadoDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ representado }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(RepresentadoDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.representado = representado;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/representado', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/representado', { outlets: { popup: null } }]);
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
