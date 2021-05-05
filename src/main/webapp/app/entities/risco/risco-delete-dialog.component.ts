import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRisco } from 'app/shared/model/risco.model';
import { RiscoService } from './risco.service';

@Component({
    selector: 'jhi-risco-delete-dialog',
    templateUrl: './risco-delete-dialog.component.html'
})
export class RiscoDeleteDialogComponent {
    risco: IRisco;

    constructor(protected riscoService: RiscoService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.riscoService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'riscoListModification',
                content: 'Deleted an risco'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-risco-delete-popup',
    template: ''
})
export class RiscoDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ risco }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(RiscoDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.risco = risco;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/risco', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/risco', { outlets: { popup: null } }]);
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
