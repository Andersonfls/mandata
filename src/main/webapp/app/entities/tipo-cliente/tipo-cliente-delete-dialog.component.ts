import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';
import { TipoClienteService } from './tipo-cliente.service';

@Component({
    selector: 'jhi-tipo-cliente-delete-dialog',
    templateUrl: './tipo-cliente-delete-dialog.component.html'
})
export class TipoClienteDeleteDialogComponent {
    tipoCliente: ITipoCliente;

    constructor(
        protected tipoClienteService: TipoClienteService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tipoClienteService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tipoClienteListModification',
                content: 'Deleted an tipoCliente'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tipo-cliente-delete-popup',
    template: ''
})
export class TipoClienteDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoCliente }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TipoClienteDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.tipoCliente = tipoCliente;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tipo-cliente', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tipo-cliente', { outlets: { popup: null } }]);
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
