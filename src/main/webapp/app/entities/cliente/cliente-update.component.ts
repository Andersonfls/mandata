import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { ICliente } from 'app/shared/model/cliente.model';
import { ClienteService } from './cliente.service';
import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';
import { TipoClienteService } from 'app/entities/tipo-cliente';
import { IEscritorio } from 'app/shared/model/escritorio.model';
import { EscritorioService } from 'app/entities/escritorio';
import {Advogado, IAdvogado} from 'app/shared/model/advogado.model';
import {User, UserService} from 'app/core';
import {Endereco, ErroCep, NgxViacepService} from '@brunoc/ngx-viacep';
import {AdvogadoService} from 'app/entities/advogado';
import {AdvogadoClienteService} from 'app/entities/advogado-cliente';
import {AdvogadoCliente, IAdvogadoCliente} from 'app/shared/model/advogado-cliente.model';

@Component({
    selector: 'jhi-cliente-update',
    templateUrl: './cliente-update.component.html'
})
export class ClienteUpdateComponent implements OnInit {
    cliente: User;
    advogado: IAdvogado;
    isSaving: boolean;

    tipoclientes: ITipoCliente[];
    escritorios: IEscritorio[];
    advogados: IAdvogado[];
    ufs: string[];
    faturamentos: string[];
    faturamento: string;

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected viacep: NgxViacepService,
        protected tipoClienteService: TipoClienteService,
        protected escritorioService: EscritorioService,
        protected activatedRoute: ActivatedRoute,
        protected userService: UserService,
        protected advogadoService: AdvogadoService,
        protected advogadoClienteService: AdvogadoClienteService
    ) {}

    ngOnInit() {
        this.advogado = new Advogado();
        this.isSaving = false;
        this.carregarListaUfs();
        this.carregarListaFaturamentos();
        this.activatedRoute.data.subscribe(({ cliente }) => {
            this.cliente = cliente;
            if (this.cliente.id === null) {
                this.cliente.status = true;
            } else {
                this.carregarListaAdvogados();
            }
        });
        this.tipoClienteService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ITipoCliente[]>) => mayBeOk.ok),
                map((response: HttpResponse<ITipoCliente[]>) => response.body)
            )
            .subscribe((res: ITipoCliente[]) => (this.tipoclientes = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.escritorioService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IEscritorio[]>) => mayBeOk.ok),
                map((response: HttpResponse<IEscritorio[]>) => response.body)
            )
            .subscribe((res: IEscritorio[]) => (this.escritorios = res), (res: HttpErrorResponse) => this.onError(res.message));

        this.advogadoService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IAdvogado[]>) => mayBeOk.ok),
                map((response: HttpResponse<IAdvogado[]>) => response.body)
            )
            .subscribe((res: IAdvogado[]) => (this.advogados = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    preencheAdvogado() {
        console.log(this.advogado);
    }

    isNullOrUndefined(object) {
        if (!object || object === undefined || object === null) {
            return true;
        }
        return false;
    }
    /*-------------ADVOGADO------------*/
    carregarListaAdvogados() {
        this.advogadoClienteService.findAdvogadosPorClienteId(this.cliente.id).subscribe((res: HttpResponse<IAdvogado[]>) => (this.advogados = res.body));
    }
    removeItemListaAdvogados(index) {
        const item: IAdvogado = this.cliente.advogados[index];
        this.advogados.push(item);
        this.cliente.advogados.splice(index, 1);
    }
    adicionarAdvogado() {
        console.log(this.advogado.id + 'aquiii');
        if (this.advogado !== null && this.advogado.id !== undefined) {
            if (this.isNullOrUndefined(this.cliente.advogados)) {
                this.cliente.advogados = new Array();
            }

            this.cliente.advogados.push(this.advogado);
            console.log('deu push aqui');
            this.advogados.splice(this.advogados.indexOf(this.advogado), 1);
            this.advogado = new Advogado();
        }
    }
    /*---------------------------------*/
    // save() {
    //     this.isSaving = true;
    //     if (this.cliente.id !== undefined) {
    //         this.subscribeToSaveResponse(this.clienteService.update(this.cliente));
    //     } else {
    //         this.subscribeToSaveResponse(this.clienteService.create(this.cliente));
    //     }
    // }

    save() {
        console.log('Cliente Antes');
        console.log(this.cliente);
        this.isSaving = true;
        if (this.cliente.id !== null) {
            this.userService.update(this.cliente).subscribe(response => {
                this.adicionaAdvogados(this.cliente.id);
              this.onSaveSuccess();
            }, () => this.onSaveError());
        } else {
            this.cliente.authorities = new Array('ROLE_USER');
            this.cliente.login = this.cliente.email;
            this.userService.create(this.cliente).subscribe(
                response => {
                    this.cliente = response.body;
                    this.jhiAlertService.addAlert({ type: 'success', msg: 'Cliente Criado com sucesso', timeout: 1000 }, []);
                    this.adicionaAdvogados(this.cliente.id);
                    this.onSaveSuccess();
                },
                () => this.onSaveError()
            );
        }
    }

    adicionaAdvogados(id) {
        // Deleta todos os relacionamentos anteriores
        this.advogadoClienteService.deleteByClienteId(id).subscribe((res: HttpResponse<any>) => {
           this.criaRelacionamentoAdvogadoCliente();
        });
    }

    criaRelacionamentoAdvogadoCliente() {
        if (this.advogados) {
            this.advogados.forEach( i => {
                const advCliente = new AdvogadoCliente();
                advCliente.status = true;
                advCliente.cliente = this.cliente;
                advCliente.advogado = i;
                this.advogadoClienteService.create(advCliente);
            });
        }
    }
    protected subscribeToSaveResponse(result: Observable<HttpResponse<ICliente>>) {
        result.subscribe((res: HttpResponse<ICliente>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackTipoClienteById(index: number, item: ITipoCliente) {
        return item.id;
    }

    trackEscritorioById(index: number, item: IEscritorio) {
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

    carregarListaFaturamentos() {
        this.faturamentos = Array<string>();
        this.faturamentos.push('Horas');
        this.faturamentos.push('Tabela');
        this.faturamentos.push('Percentual');
        this.faturamentos.push('Fixo');
    }

    /*----------------------CEP-------------------------*/
    trim(strTexto) {
        // Substitúi os espaços vazios no inicio e no fim da string por vazio.
        return strTexto.replace(/^s+|s+$/g, '');
    }
    isCEPvalido(strCEP) {
        // Caso o CEP não esteja nesse formato ele é inválido!
        const objER = /^[0-9]{8}$/;

        strCEP = this.trim(strCEP);
        if (strCEP.length > 0) {
            console.log('Entron validacao de lenght' + objER.test(strCEP));
            if (objER.test(strCEP)) {
                return true;
            }
        } else {
            return false;
        }
    }
    buscarCep(tipo) {
        let cep = this.cliente.cep;

        if (cep !== undefined) {
            cep = cep.replace(/\D/g, '');
        }

        if (this.isCEPvalido(cep)) {
            this.viacep
                .buscarPorCep(cep)
                .then((endereco: Endereco) => {
                    // Endereço retornado :)
                    console.log(endereco);
                    this.trataResultadoEndereco(endereco);
                })
                .catch((error: ErroCep) => {
                    // Alguma coisa deu errado :/
                    console.log(error.message);
                });
        } else {
            alert('cep invalido');
        }
    }
    trataResultadoEndereco(endereco: Endereco) {
            this.cliente.logradouro = endereco.logradouro;
            this.cliente.complemento = endereco.complemento;
            this.cliente.bairro = endereco.bairro;
            this.cliente.cidade = endereco.localidade;
            this.cliente.uf = endereco.uf;
            this.cliente.cep = endereco.cep;
            console.log('preencheu CEP LIVRO');
        }
}
