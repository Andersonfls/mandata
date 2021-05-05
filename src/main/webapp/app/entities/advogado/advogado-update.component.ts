import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IAdvogado } from 'app/shared/model/advogado.model';
import { AdvogadoService } from './advogado.service';
import { IEscritorio } from 'app/shared/model/escritorio.model';
import { EscritorioService } from 'app/entities/escritorio';
import { ICliente } from 'app/shared/model/cliente.model';
import { ClienteService } from 'app/entities/cliente';
import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';
import { TipoAdvogadoService } from 'app/entities/tipo-advogado';

@Component({
    selector: 'jhi-advogado-update',
    templateUrl: './advogado-update.component.html'
})
export class AdvogadoUpdateComponent implements OnInit {
    advogado: IAdvogado;
    isSaving: boolean;

    escritorios: IEscritorio[];

    clientes: ICliente[];

    tipoadvogados: ITipoAdvogado[];
    ufs: string[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected advogadoService: AdvogadoService,
        protected escritorioService: EscritorioService,
        protected clienteService: ClienteService,
        protected tipoAdvogadoService: TipoAdvogadoService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.carregarListaUfs();
        this.activatedRoute.data.subscribe(({ advogado }) => {
            this.advogado = advogado;
        });
        this.escritorioService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IEscritorio[]>) => mayBeOk.ok),
                map((response: HttpResponse<IEscritorio[]>) => response.body)
            )
            .subscribe((res: IEscritorio[]) => (this.escritorios = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.clienteService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ICliente[]>) => mayBeOk.ok),
                map((response: HttpResponse<ICliente[]>) => response.body)
            )
            .subscribe((res: ICliente[]) => (this.clientes = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.tipoAdvogadoService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ITipoAdvogado[]>) => mayBeOk.ok),
                map((response: HttpResponse<ITipoAdvogado[]>) => response.body)
            )
            .subscribe((res: ITipoAdvogado[]) => (this.tipoadvogados = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.advogado.id !== undefined) {
            this.subscribeToSaveResponse(this.advogadoService.update(this.advogado));
        } else {
            this.subscribeToSaveResponse(this.advogadoService.create(this.advogado));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IAdvogado>>) {
        result.subscribe((res: HttpResponse<IAdvogado>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackEscritorioById(index: number, item: IEscritorio) {
        return item.id;
    }

    trackClienteById(index: number, item: ICliente) {
        return item.id;
    }

    trackTipoAdvogadoById(index: number, item: ITipoAdvogado) {
        return item.id;
    }

    carregarListaUfs() {
        this.ufs = Array<string>();
        this.ufs.push('AC');
        this.ufs.push('AL');
        this.ufs.push('AP');
        this.ufs.push('AM');
        this.ufs.push('BA');
        this.ufs.push('CE');
        this.ufs.push('DF');
        this.ufs.push('ES');
        this.ufs.push('GO');
        this.ufs.push('MA');
        this.ufs.push('MT');
        this.ufs.push('MS');
        this.ufs.push('MG');
        this.ufs.push('PA');
        this.ufs.push('PB');
        this.ufs.push('PR');
        this.ufs.push('PE');
        this.ufs.push('PI');
        this.ufs.push('RJ');
        this.ufs.push('RN');
        this.ufs.push('RS');
        this.ufs.push('RO');
        this.ufs.push('RR');
        this.ufs.push('SC');
        this.ufs.push('SP');
        this.ufs.push('SE');
        this.ufs.push('TO');
    }
}
