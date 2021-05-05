import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITipoEvento } from 'app/shared/model/tipo-evento.model';
import { TipoEventoService } from './tipo-evento.service';

@Component({
    selector: 'jhi-tipo-evento-delete-dialog',
    templateUrl: './tipo-evento-delete-dialog.component.html'
})
export class TipoEventoDeleteDialogComponent {
    tipoEvento: ITipoEvento;

    constructor(
        protected tipoEventoService: TipoEventoService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tipoEventoService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tipoEventoListModification',
                content: 'Deleted an tipoEvento'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tipo-evento-delete-popup',
    template: ''
})
export class TipoEventoDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tipoEvento }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TipoEventoDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.tipoEvento = tipoEvento;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/tipo-evento', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/tipo-evento', { outlets: { popup: null } }]);
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
