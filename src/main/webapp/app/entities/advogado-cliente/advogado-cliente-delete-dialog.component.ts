import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';
import { AdvogadoClienteService } from './advogado-cliente.service';

@Component({
    selector: 'jhi-advogado-cliente-delete-dialog',
    templateUrl: './advogado-cliente-delete-dialog.component.html'
})
export class AdvogadoClienteDeleteDialogComponent {
    advogado_cliente: IAdvogadoCliente;

    constructor(
        protected advogado_clienteService: AdvogadoClienteService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.advogado_clienteService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'advogado_clienteListModification',
                content: 'Deleted an advogado_cliente'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-advogado-cliente-delete-popup',
    template: ''
})
export class AdvogadoClienteDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ advogado_cliente }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AdvogadoClienteDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.advogado_cliente = advogado_cliente;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/advogado-cliente', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/advogado-cliente', { outlets: { popup: null } }]);
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
