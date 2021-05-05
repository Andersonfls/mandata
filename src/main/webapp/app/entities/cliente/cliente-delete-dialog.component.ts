import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import {User, UserService} from 'app/core';

@Component({
    selector: 'jhi-cliente-delete-dialog',
    templateUrl: './cliente-delete-dialog.component.html'
})
export class ClienteDeleteDialogComponent {
    cliente: User;

    constructor(protected clienteService: UserService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(login) {
        this.clienteService.delete(login).subscribe(response => {
            this.eventManager.broadcast({
                name: 'clienteListModification',
                content: 'Deleted an cliente'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-cliente-delete-popup',
    template: ''
})
export class ClienteDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ cliente }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(ClienteDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.cliente = cliente;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/cliente', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/cliente', { outlets: { popup: null } }]);
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
