import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITribunal } from 'app/shared/model/tribunal.model';
import { TribunalService } from './tribunal.service';

@Component({
    selector: 'jhi-tribunal-delete-dialog',
    templateUrl: './tribunal-delete-dialog.component.html'
})
export class TribunalDeleteDialogComponent {
    tribunal: ITribunal;

    constructor(protected tribunalService: TribunalService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tribunalService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tribunalListModification',
                content: 'Deleted an tribunal'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tribunal-delete-popup',
    template: ''
})
export class TribunalDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tribunal }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TribunalDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.tribunal = tribunal;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tribunal', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tribunal', { outlets: { popup: null } }]);
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
