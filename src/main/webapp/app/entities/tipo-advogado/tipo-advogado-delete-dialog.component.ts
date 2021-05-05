import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';
import { TipoAdvogadoService } from './tipo-advogado.service';

@Component({
    selector: 'jhi-tipo-advogado-delete-dialog',
    templateUrl: './tipo-advogado-delete-dialog.component.html'
})
export class TipoAdvogadoDeleteDialogComponent {
    tipoAdvogado: ITipoAdvogado;

    constructor(
        protected tipoAdvogadoService: TipoAdvogadoService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tipoAdvogadoService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tipoAdvogadoListModification',
                content: 'Deleted an tipoAdvogado'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tipo-advogado-delete-popup',
    template: ''
})
export class TipoAdvogadoDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoAdvogado }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TipoAdvogadoDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.tipoAdvogado = tipoAdvogado;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tipo-advogado', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tipo-advogado', { outlets: { popup: null } }]);
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
