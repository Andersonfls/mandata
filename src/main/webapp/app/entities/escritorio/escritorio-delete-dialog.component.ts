import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IEscritorio } from 'app/shared/model/escritorio.model';
import { EscritorioService } from './escritorio.service';

@Component({
    selector: 'jhi-escritorio-delete-dialog',
    templateUrl: './escritorio-delete-dialog.component.html'
})
export class EscritorioDeleteDialogComponent {
    escritorio: IEscritorio;

    constructor(
        protected escritorioService: EscritorioService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.escritorioService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'escritorioListModification',
                content: 'Deleted an escritorio'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-escritorio-delete-popup',
    template: ''
})
export class EscritorioDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ escritorio }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(EscritorioDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.escritorio = escritorio;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/escritorio', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/escritorio', { outlets: { popup: null } }]);
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
