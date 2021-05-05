import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { JhiLanguageHelper, User, UserService } from 'app/core';
import { NgxViacepService } from '@brunoc/ngx-viacep';
import { JhiAlertService } from 'ng-jhipster';
import { IDocumento } from 'app/shared/model/documento.model';
import { SituacaoService } from './services/situacao.service';
import { CertificadoService } from './services/certificado.service';
import { MatriculaService } from './services/matricula.service';
import { MatriculaCursoService } from './services/matriculaCurso.service';
import { ProvaAlunoService } from './services/provaAluno.service';
import { DebitoAlunoService } from './services/debitoAluno.service';
import { DocumentoService } from './services/documento.service';

@Component({
    selector: 'jhi-aluno-update',
    templateUrl: './aluno-update.component.html',
    styleUrls: ['aluno.scss']
})
export class AlunoUpdateComponent implements OnInit {
    /*Objetos*/
    user: User;

    /*Configuração*/
    languages: any[];
    authorities: any[];
    documentos: IDocumento;

    @ViewChild('inputFile') inputFile: any;

    constructor(
        private languageHelper: JhiLanguageHelper,
        private userService: UserService,
        private route: ActivatedRoute,
        private router: Router,
        private viacep: NgxViacepService,
        protected situacaoService: SituacaoService,
        protected certificadoService: CertificadoService,
        protected provaAlunoService: ProvaAlunoService,
        private jhiAlertService: JhiAlertService,
        protected documentoService: DocumentoService,
        protected matriculaService: MatriculaService,
        protected matriculaCursoService: MatriculaCursoService,
        protected debitoAlunoService: DebitoAlunoService
    ) {}

    ngOnInit() {
        /* this.isSaving = false;
        this.entregaLivrosEnderecoDiferente = false;
        this.controleSessoes = '';
        this.situacaoMatricula = new SituacaoMatricula();
        this.certificado = new Certificado();
        this.provaAluno = new ProvaAluno();
        this.documentos = new Documento();
        this.matriculaCurso = new MatriculaCurso();
        this.debito = new Debito();
        this.debitoAluno = new DebitoAluno();
        this.myDate = new Date();
        this.route.data.subscribe(({ user }) => {
            this.user = user.body ? user.body : user;
        });
        this.authorities = [];
        this.userService.authorities().subscribe(authorities => {
            this.authorities = authorities;
        });
        this.languageHelper.getAll().then(languages => {
            this.languages = languages;
        });
        this.fichasAcompanhamnento = new Array<IFichaAcompanhamento>();
        this.maskPercentage = {
            mask: createNumberMask({
                prefix: '',
                suffix: '%',
                allowDecimal: true,
                decimalLimit: 2,
                integerLimit: 3
            })
        };

        /!*     if (this.user.id) {
            if (this.user.cepEntLivro !== this.user.cep) {
                this.entregaLivrosEnderecoDiferente = true;
            }
            this.buscarMatriculaAluno();
        }*!/

        this.loadAll();

        const ficha = new FichaAcompanhamento();
        ficha.nota = 9.8;
        ficha.correcao = 'Manual';
        ficha.dataAvaliacao = new Date();
        ficha.sequencia = 4;
        this.fichasAcompanhamnento.push(ficha);

        if (this.isNullOrUndefined(this.matricula)) {
            this.matricula = new Matricula();
        }
        console.log('usuario carregado-->');
        console.log(this.user);
        this.abaDados = false;
        this.abaDocumentos = false;
        this.abaAtiva = 'dados';
        this.matriculaCurso.convenios = null;*/
    }

    /* clean() {
        // alert('asdlaksjd');
    }

    loadAll() {
        // this.carregarListaProfissoes();
        // this.carregarListaCargos();
        // this.carregarListaEstadoCivi();
        // this.carregarListaUfs();
        // this.carregarListGrauInstrucao();
        // this.carregarListaNacionalidades();
        // this.carregarListaRacas();
        // this.carregarListaConhecimentoEscolas();
        // this.carregarListaTipoContrato();
        // this.carregarListaFormaPagamento();
        // this.carregarListaConvenios();
        // this.carregarListaTpSanguineo();
        // this.carregarListaEmissores();
        // this.carregarListaProdutos();
        // this.carregarListaNucleos();
        // this.carregarListaRepresentantes();
        // this.carregarListaProvasTipo();
        /!*this.status();
        this.buscarDebitos();
        this.buscarDebitosAluno();

        this.situacaoService
            .findSitMatricula(1)
            .subscribe((res: HttpResponse<ISituacaoMatricula[]>) => (this.situacoesMatricula = res.body));
        this.escolaService.query().subscribe((res: HttpResponse<IEscola[]>) => (this.escolas = res.body));
        this.areaService.query().subscribe((res: HttpResponse<IArea[]>) => (this.areas = res.body));
        this.cursoService.query().subscribe((res: HttpResponse<ICurso[]>) => (this.cursos = res.body));
        this.situacaoService.query().subscribe((res: HttpResponse<ISituacao[]>) => (this.tiposSituacoes = res.body));
        this.provaAlunoService.queryProva().subscribe((res: HttpResponse<IProvaAluno[]>) => (this.provas = res.body));
        this.provaAlunoService.query().subscribe((res: HttpResponse<IProvaAluno[]>) => (this.listaNotas = res.body));*!/
    }

    adicionarConvenio() {
       /!* if (this.isNullOrUndefined(this.matriculaCurso.convenios)) {
            this.matriculaCurso.convenios = new Array();
        }

        this.matriculaCurso.convenios.push(this.convenio);
        this.alterarValorFinal(this.convenio.percentual);
        this.convenios.splice(this.convenios.indexOf(this.convenio), 1);
        this.convenio = null;*!/
    }

    removeItemListaConvenios(index) {
        /!*const item: IConvenio = this.matriculaCurso.convenios[index];
        this.convenios.push(item);
        this.matriculaCurso.convenios.splice(index, 1);
        // calcula o valor novamente
        this.matriculaCurso.valorFinal = this.matriculaCurso.valorOriginal;
        this.matriculaCurso.convenios.forEach(i => {
            this.alterarValorFinal(i.percentual);
        });*!/
    }

    alterarValorFinal(percentagem) {
        const percentagemValor = (this.matriculaCurso.valorFinal * percentagem) / 100;
        this.matriculaCurso.valorFinal = this.matriculaCurso.valorFinal - percentagemValor;
    }

    alterarValorDebitoAluno() {
        this.debitoAluno.total = this.debitoAluno.debito.valor * this.debitoAluno.quantidade;
    }

    alterarValor() {
        this.debitoAluno.valor = this.debitoAluno.debito.valor;
        this.debitoAluno.quantidade = 1;
        this.alterarValorDebitoAluno();
    }

    alteraValorTotalCurso() {
        console.log(this.matriculaCurso.curso);
        if (this.matriculaCurso.curso != null) {
            this.matriculaCurso.valorOriginal = this.matriculaCurso.curso.contratoTotal;
            this.matriculaCurso.valorFinal = this.matriculaCurso.curso.contratoTotal;
            this.convenio = null;
            this.matriculaCurso.convenios = new Array();
        }
    }
    alterarTab(valor) {
        this.abaAtiva = valor;
    }

    buscarDebitos() {
        this.debitoService.query().subscribe((res: HttpResponse<DebitoAluno[]>) => (this.listaDebitos = res.body));
    }

    buscarDebitosAluno() {
        if (this.user.id != null) {
            this.debitoAlunoService
                .findAllByAluno(this.user.id)
                .subscribe((res: HttpResponse<DebitoAluno[]>) => (this.debitosAluno = res.body));
        }
    }

    baixaDebitoAluno(index) {
        const item: IDebitoAluno = this.debitosAluno[index];
        item.dataBaixa = new Date();
        this.debitoAlunoService.update(item).subscribe((res: HttpResponse<DebitoAluno>) => (this.debitosAluno[index] = res.body));
    }

    buscarMatriculaAluno() {
        this.matriculaService.findMatriculaAluno(this.user.id).subscribe((res: HttpResponse<IMatricula>) => {
            this.matricula = res.body;
            console.log(this.matricula);
            if (this.matricula !== null && this.matricula.id) {
                // BUSCA DOCUMENTOS E ARQUIVOS NO DIRETORIO DO ALUNO
                this.loadDocumentos(this.user.id);
                this.buscarMatriculasCursos();
                this.loadArquivos(this.user.id);
                console.log('Chamou Funcao busca de Arquivos!!!');
            }
        });
    }

    buscarMatriculasCursos() {
        if (this.isNullOrUndefined(this.matriculaCursos)) {
            this.matriculaCursos = new Array();
        }

        if (this.user.id !== null) {
            this.matriculaCursoService.findAllByAluno(this.user.id).subscribe(
                response => {
                    this.matriculaCursos = response.body;
                    console.log(this.matriculaCursos);
                },
                () => this.onSaveError()
            );
        }
    }
    /!* gravarMatriculaCurso() {
        this.matriculaCurso.alunoCpf = this.user.cpf;
        this.matriculaCurso.matricula = this.matricula;
        console.log(this.matriculaCurso);
        this.matriculaCursoService.create(this.matriculaCurso).subscribe(
            response => {
                this.matriculaCurso = response.body;

                if (this.matriculaCursos == null) {
                    this.matriculaCursos = new Array();
                }
                this.matriculaCursos.push(this.matriculaCurso);
                console.log(this.matriculaCurso);
                alert('Matrícula criada com sucesso!');
                this.matriculaCurso = new MatriculaCurso();
            },
            () => this.onSaveError()
        );
    }*!/

    // criarMatricula() {
    //     this.matricula = new Matricula();
    //     this.matricula.usuario = this.user;
    //     this.matricula.alunoCpf = this.user.cpf;
    //     this.matriculaService.create(this.matricula).subscribe(
    //         response => {
    //             this.matricula = response.body;
    //             console.log(this.matricula);
    //         },
    //         () => this.onSaveError()
    //     );
    // }

    gravarHistoricoSituacaoMatricula() {
        this.situacaoMatricula.dataEmissao = new Date();
        this.situacaoMatricula.matricula = this.matricula;
        this.situacaoMatricula.usuario = this.user;
        this.situacaoService.createSitMatricula(this.situacaoMatricula).subscribe(response => {
            if (response instanceof HttpResponse) {
                this.situacaoService
                    .findSitMatricula(this.matricula.id)
                    .subscribe((res: HttpResponse<ISituacaoMatricula[]>) => (this.situacoesMatricula = res.body));
                console.log('Chamada funcao de Situacao Matricula');
                console.log(this.situacaoMatricula);
                alert('Situacao Gravada com sucesso!!');
            }
        });
    }

    gravarCertificado() {
        this.certificado.matricula = this.matricula;
        this.certificadoService.create(this.certificado).subscribe();

        alert('Certificado Gravado com sucesso!!');
    }

    gravarDebito() {
        this.debito.status = true;
        this.debitoService.create(this.debito).subscribe(response => {
            alert('Débito cadastrado com sucesso!!');
            if (this.listaDebitos == null) {
                this.listaDebitos = new Array();
            }
            this.listaDebitos.push(response.body);
            console.log(response.body);
            this.debito = new Debito();
        });
    }

    gravarDebitoAluno() {
        this.debitoAluno.matricula = this.matricula;
        console.log(this.debitoAluno);
        this.debitoAlunoService.create(this.debitoAluno).subscribe(response => {
            alert('Débito cadastrado com sucesso!!');
            if (this.debitosAluno == null) {
                this.debitosAluno = new Array();
            }
            this.debitosAluno.push(response.body);
            console.log(response.body);
        });
    }

    gravarProvaAluno() {
        this.provaAluno.matricula = this.matricula;
        this.provaAlunoService.create(this.provaAluno).subscribe();
        console.log(this.provaAluno);
        alert('Nota Gravada com sucesso!!');
    }

    validarCertificado() {
        this.certificadoService.findValidador(this.validador).subscribe((res: HttpResponse<ICertificado>) => (this.certificado = res.body));
        alert('Busca realizada com sucesso!!');
        console.log(this.certificado);
    }

    /!*---------------ARQUIVOS------------*!/
    resetInputFile() {
        this.inputFile.nativeElement.value = '';
        console.log(this.inputFile.nativeElement.files);
    }

    selectFile(event) {
        const file = event.target.files.item(0);
        this.selectedFile = event.target.files.item(0);
    }

    deleteFile(file: FileResponseModel, tipo: string) {
        if (confirm('O arquivo será excluído do Sistema, deseja continuar?')) {
            this.documentoService.deleteArquivo(this.matricula.chave, file.fileName).subscribe(event => {
                if (event instanceof HttpResponse) {
                    console.log('File was deleted!');
                    if (tipo === 'RG') {
                        this.documentos.arquivoRg = null;
                        this.documentos.uriRg = null;
                    } else if (tipo === 'CERTIDAO') {
                        this.documentos.arquivoCertidao = null;
                        this.documentos.uriCertidao = null;
                    } else if (tipo === 'CONTRATODIGITALIZADO') {
                        this.documentos.arquivoContrato = null;
                        this.documentos.uriContrato = null;
                    } else if (tipo === 'CPF') {
                        this.documentos.arquivoCpf = null;
                        this.documentos.uriCpf = null;
                    } else if (tipo === 'DECJUDICIAL') {
                        this.documentos.arquivoDecJudical = null;
                        this.documentos.uriDecJudical = null;
                    } else if (tipo === 'RESERVISTA') {
                        this.documentos.arquivoReservista = null;
                        this.documentos.uriReservista = null;
                    } else if (tipo === 'TITULOELEITOR') {
                        this.documentos.arquivoTitulo = null;
                        this.documentos.uriTitulo = null;
                    } else if (tipo === 'TPSANGUINEO') {
                        this.documentos.arquivoTipoSanguineo = null;
                        this.documentos.uriTipoSanguineo = null;
                    }

                    this.salvarDadosDocumentos();
                }
            });
        }
    }

    loadArquivos(alunoId) {
        this.documentoService.findAllFilesByAlunoId(alunoId).subscribe(event => {
            if (event instanceof HttpResponse) {
                console.log('Loading files !');
                const files: FileResponseModel[] = <FileResponseModel[]>event.body;
                console.log(files);
                if (files) {
                    files.forEach(file => {
                        this.tratarRespostaUpload(file);
                    });
                }
            }
        });
    }

    loadDocumentos(alunoId) {
        this.documentoService.findByUsuarioId(alunoId).subscribe(event => {
            if (event instanceof HttpResponse) {
                console.log('Loading Documentos !');
                this.documentos = event.body;
            }
        });
    }

    upload(nomeArquivo: string) {
        if (this.selectedFile) {
            const arrayBlob = new Array<Blob>();
            arrayBlob.push(this.selectedFile);
            const extensaoArquivo = this.selectedFile.name.split('.');
            console.log(extensaoArquivo);
            const novoArquivo = new File(arrayBlob, nomeArquivo + '.' + extensaoArquivo[extensaoArquivo.length - 1]);
            this.documentoService.uploadDocumento(this.matricula.chave, novoArquivo).subscribe(
                event => {
                    if (event instanceof HttpResponse) {
                        console.log('File is completely uploaded!');
                        const jsonObj: any = JSON.parse(event.body.toString());
                        const file: FileResponseModel = <FileResponseModel>jsonObj;
                        this.tratarRespostaUpload(file);
                        this.resetInputFile();
                    }
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
        }
    }

    tratarRespostaUpload(file: FileResponseModel) {
        console.log('ENTROU NO METODO DE TRATAR RESPOSTA ARQUIVO');
        console.log(file);
        if (file.tipoDocumento === 'RG') {
            this.documentos.arquivoRg = file;
            this.documentos.uriRg = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'CERTIDAO') {
            this.documentos.arquivoCertidao = file;
            this.documentos.uriCertidao = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'CONTRATODIGITALIZADO') {
            this.documentos.arquivoContrato = file;
            this.documentos.uriContrato = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'CPF') {
            this.documentos.arquivoCpf = file;
            this.documentos.uriCpf = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'DECJUDICIAL') {
            this.documentos.arquivoDecJudical = file;
            this.documentos.uriDecJudical = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'RESERVISTA') {
            this.documentos.arquivoReservista = file;
            this.documentos.uriReservista = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'TITULOELEITOR') {
            this.documentos.arquivoTitulo = file;
            this.documentos.uriTitulo = file.fileDownloadUri;
        } else if (file.tipoDocumento === 'TPSANGUINEO') {
            this.documentos.arquivoTipoSanguineo = file;
            this.documentos.uriTipoSanguineo = file.fileDownloadUri;
        }
    }

    tratarNomeArquivo(nome: string) {
        // SOBE O ARQUIVO PARA A PASTA DO ALUNO
        this.upload(nome);
        // SALVA OS DADOS DO DOCUMENTO
        this.salvarDadosDocumentos();
    }

    salvarDadosDocumentos() {
        console.log(this.documentos);
        // PERSISTE DADOS DOCUMENTO
        if (this.documentos.id !== null) {
            console.log('UPDATE DOCUMENTO');
            console.log(this.documentos);
            this.documentoService.update(this.documentos).subscribe(response => (this.documentos = response.body));
        } else {
            console.log('CREATE DOCUMENTO');
            this.documentos.matricula = this.matricula;
            console.log(this.documentos);
            this.documentoService.create(this.documentos).subscribe(response => (this.documentos = response.body));
        }
    }

    save() {
        this.isSaving = true;
        this.user.login = this.user.email;
        if (this.user.id !== null) {
            this.userService.update(this.user).subscribe(response => (this.user = response.body), () => this.onSaveError());
        } else {
            this.userService.create(this.user).subscribe(
                response => {
                    this.user = response.body;
                    console.log(this.user);
                    // this.criarMatricula();
                    /!*this.buscarMatriculaAluno();
                    if (this.user.escola.nome === 'CETEB') {
                        this.alterarTab('documentos');
                    } else {
                        this.alterarTab('cursos');
                    }*!/

                    this.jhiAlertService.addAlert({ type: 'success', msg: 'Usuario Criado com sucesso', timeout: 1000 }, []);
                },
                () => this.onSaveError()
            );
        }
    }

    saveAndPrevious() {
        this.save();
        this.previousState();
    }

    openFile(url) {
        window.open(url, '_blank');
    }

    habilitarTela(valor) {
        this.controleSessoes = valor;
        console.log(this.user);
        this.situacaoService
            .findSitMatricula(this.matricula.id)
            .subscribe((res: HttpResponse<ISituacaoMatricula[]>) => (this.situacoesMatricula = res.body));
        console.log(this.situacoesMatricula);
    }

    /!*carregarListaEmissores() {
        this.emissores = Array<string>();
        this.emissores.push('CARTEIRA DE IDENTIDADE CLASSISTA');
        this.emissores.push('CONSELHO REGIONAL CORRETORES DE IMÓVEIS');
        this.emissores.push('CONSELHO REGIONAL DE ADMINISTRAÇÃO');
        this.emissores.push('CONSELHO REGIONAL DE ASSISTENTES SOCIAIS ');
        this.emissores.push('CONSELHO REGIONAL DE BIBLIOTECONOMIA');
        this.emissores.push('CONSELHO REGIONAL DE CONTABILIDADE');
        this.emissores.push('CONSELHO REGIONAL DE ESTATÍSTICA');
        this.emissores.push('CONSELHO REGIONAL DE FARMÁCIA');
        this.emissores.push('CONSELHO REGIONAL DE MEDICINA');
        this.emissores.push('CONSELHO REGIONAL DE NUTRICAO');
        this.emissores.push('CONSELHO REGIONAL DE ODONTOLOGIA');
        this.emissores.push('CONSELHO REGIONAL DE PSICOLOGIA');
        this.emissores.push('CONSELHO REGIONAL DE QUÍMICA');
        this.emissores.push('CONSELHO REGIONAL DE ENFERMAGEM');
        this.emissores.push('CONSELHO REGIONAL DE ENG.ARQ. E AGRONOMIA');
        this.emissores.push('CONSELHO REGIONAL DE FISIOTERAPIA OCUPACIONAL');
        this.emissores.push('CONSELHO REGIONAL DE MEDICINA VETERINÁRIA');
        this.emissores.push('CONSELHO REGIONAL DE RELACOES PÚBLICAS');
        this.emissores.push('CONSELHO REGIONAL DE REPRES. COMERCIAIS');
        this.emissores.push('DOCUMENTOS ESTRANGEIROS');
        this.emissores.push('MINISTÉRIO DA AERONÁUTICA');
        this.emissores.push('MINISTÉRIO DA MARINHA ');
        this.emissores.push('MINISTÉRIO DO EXÉRCITO ');
        this.emissores.push('ORDEM DOS ADVOGADOS DO BRASIL');
        this.emissores.push('OUTROS EMISSORES ');
        this.emissores.push('POLICIA FEDERAL');
        this.emissores.push('SECRETARIA DA JUSTIÇA E DA SEGURANÇA');
        this.emissores.push('SSP-SECRETARIA DE SEGURANÇA PÚBLICA');
    }*!/

    /!*   carregarListaRepresentantes() {
        this.representantes = Array<string>();
        this.representantes.push('Representente 1');
        this.representantes.push('Rep 5');
    }*!/

    /!*    carregarListaProvasTipo() {
        this.tiposProva = Array<string>();
        this.tiposProva.push('Online');
        this.tiposProva.push('Presencial');
    }*!/
    /!*  carregarListaNucleos() {
        this.nucleos = Array<string>();
        this.nucleos.push('nucleo 2');
        this.nucleos.push('nucleo 3');
    }*!/

    /!*    carregarListaProdutos() {
        this.produtos = Array<string>();
        this.produtos.push('Online');
        this.produtos.push('Presencial');
    }*!/

    /!*    carregarListaTpSanguineo() {
        this.tiposSanqguineos = Array<string>();
        this.tiposSanqguineos.push('A+');
        this.tiposSanqguineos.push('A-');
        this.tiposSanqguineos.push('B+');
        this.tiposSanqguineos.push('B-');
        this.tiposSanqguineos.push('AB+');
        this.tiposSanqguineos.push('AB-');
        this.tiposSanqguineos.push('O+');
        this.tiposSanqguineos.push('0-');
    }*!/

    /!*carregarListaConvenios() {
        this.convenioService.query().subscribe((res: HttpResponse<IConvenio[]>) => (this.convenios = res.body));
    }
    carregarListaFormaPagamento() {
        this.listaFormaPagamento = Array<string>();
        this.listaFormaPagamento.push('Avista');
        this.listaFormaPagamento.push('Parcelado)');
    }
    carregarListaTipoContrato() {
        this.listaTpContrato = Array<string>();
        this.listaTpContrato.push('Ensino Fundamental');
        this.listaTpContrato.push('Ensino Médio');
        this.listaTpContrato.push('30 dias');
        this.listaTpContrato.push('60 dias');
        this.listaTpContrato.push('180 dias');
    }
    carregarListaConhecimentoEscolas() {
        this.listaConhecimentoEscola = Array<string>();
        this.listaConhecimentoEscola.push('Google');
        this.listaConhecimentoEscola.push('Indicacao Amigo');
        this.listaConhecimentoEscola.push('Jornal');
        this.listaConhecimentoEscola.push('Televisao');
        this.listaConhecimentoEscola.push('Outros');
    }
    carregarListaRacas() {
        this.listaRacas = Array<string>();
        this.listaRacas.push('Branco');
        this.listaRacas.push('Pardo');
        this.listaRacas.push('Amarelo');
        this.listaRacas.push('Outro');
    }
    carregarListaNacionalidades() {
        this.nacionalidades = Array<string>();
        this.nacionalidades.push('Brasileira');
        this.nacionalidades.push('Alema');
        this.nacionalidades.push('Panamenha');
        this.nacionalidades.push('Chilena');
        this.nacionalidades.push('Uruguaia');
        this.nacionalidades.push('Peruana');
    }
*!/
    /!*    carregarListaProfissoes() {
        this.profissoes = Array<string>();
        this.profissoes.push('Administrador');
        this.profissoes.push('Advogado');
        this.profissoes.push('Aeronauta');
        this.profissoes.push('Arquivista / Técnico de Arquivo');
        this.profissoes.push('Artista/Técnico em espetáculos de diversoes');
        this.profissoes.push('Assistente Social');
        this.profissoes.push('Atleta Profissional de Futebol');
        this.profissoes.push('Atuário');
        this.profissoes.push('Bibliotecário');
        this.profissoes.push('Biomédico');
        this.profissoes.push('Biólogo');
        this.profissoes.push('Bombeiri Civil');
        this.profissoes.push('Comerciário');
        this.profissoes.push('Contabilista');
        this.profissoes.push('Corretor de Imóveis');
        this.profissoes.push('Corretor de Seguros');
        this.profissoes.push('Despachante Aduaneiro');
        this.profissoes.push('Engenheiro/ Arquiteto/ Agronomo');
        this.profissoes.push('Economista Doméstico');
        this.profissoes.push('Economista');
        this.profissoes.push('Educador Físico');
        this.profissoes.push('Empregado Doméstico');
        this.profissoes.push('Enfermagem');
        this.profissoes.push('Engenharia de Seguranca');
        this.profissoes.push('Estatístico');
        this.profissoes.push('Fisioterapeuta e Terapeuta Ocupacional');
        this.profissoes.push('Farmaceutico');
        this.profissoes.push('Fonaudiólogo');
        this.profissoes.push('Garimpeiro');
        this.profissoes.push('Geógrafo');
        this.profissoes.push('Geólogo');
        this.profissoes.push('Guardador e Lavador de Veículos');
        this.profissoes.push('Intrutor de Transito');
        this.profissoes.push('Jornalista');
        this.profissoes.push('Leiloeiro');
        this.profissoes.push('Leiloeiro Rural');
        this.profissoes.push('Massagista');
        this.profissoes.push('Médico');
        this.profissoes.push('Medicina Veterinária');
        this.profissoes.push('Mototaxista e Motoboy');
        this.profissoes.push('Museólogo');
        this.profissoes.push('Músico');
        this.profissoes.push('Nutricionista');
        this.profissoes.push('Oceanógrafo');
        this.profissoes.push('Odontologia');
        this.profissoes.push('Orientador Educacional');
        this.profissoes.push('Peao de Rodeio');
        this.profissoes.push('Pescador Profissional');
        this.profissoes.push('Psicologia');
        this.profissoes.push('Publicitário/Agenciador de Propaganda');
        this.profissoes.push('Químico');
        this.profissoes.push('Radialista');
        this.profissoes.push('Relacoes Públicas');
        this.profissoes.push('Representantes Comerciais Autonomos');
        this.profissoes.push('Repentista');
        this.profissoes.push('Secretário - Secretário Executivo e Técnico de Secretariado');
        this.profissoes.push('Sociólogo');
        this.profissoes.push('Sommelier');
        this.profissoes.push('Taxista');
        this.profissoes.push('Tradutor e Intérprete da Língua Brasileira de Sinais - LIBRAS');
        this.profissoes.push('Técnico em Administracao');
        this.profissoes.push('Técnico Industrial');
        this.profissoes.push('Técnico em Prótese Dentária');
        this.profissoes.push('Técnico em Radiologia');
        this.profissoes.push('Turismólogo');
        this.profissoes.push('Zootecnista');
    }

    carregarListaCargos() {
        this.cargos = Array<string>();
        this.cargos.push('Analista');
        this.cargos.push('Operário');
        this.cargos.push('Advogado');
        this.cargos.push('Ajudante');
    }

    carregarListaEstadoCivi() {
        this.estadosCivis = Array<string>();
        this.estadosCivis.push('Solteiro(a)');
        this.estadosCivis.push('Casado(a)');
        this.estadosCivis.push('Divorciado(a)');
        this.estadosCivis.push('Viúvo(a)');
        this.estadosCivis.push('Separado(a)');
    }

    carregarListGrauInstrucao() {
        this.instrucoes = Array<string>();
        this.instrucoes.push('Analfabeto');
        this.instrucoes.push('Ensino fundamental incompleto');
        this.instrucoes.push('Ensino fundamental completo');
        this.instrucoes.push('Ensino médio incompleto');
        this.instrucoes.push('Ensino médio completo');
        this.instrucoes.push('Superior incompleto');
        this.instrucoes.push('Superior completo');
        this.instrucoes.push('Pós-graduação');
        this.instrucoes.push('Mestrado');
        this.instrucoes.push('Doutorado');
        this.instrucoes.push('Pós-Doutorado');
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

    buscarCep(tipo) {
        let cep;
        if (tipo === 'cep') {
            cep = this.user.cep;
        } else if (tipo === 'cepLivro') {
            cep = this.user.cepEntLivro;
        } else if (tipo === 'cepFinanceiro') {
            cep = this.user.cepRespFinanceiro;
        } else if (tipo === 'cepPedagogico') {
            cep = this.user.cepRespPedagogico;
        }

        if (cep !== undefined) {
            cep = cep.replace(/\D/g, '');
        }
        if (this.isCEPvalido(cep)) {
            this.viacep
                .buscarPorCep(cep)
                .then((endereco: Endereco) => {
                    // Endereço retornado :)
                    console.log(endereco);
                    this.trataResultadoEndereco(endereco, tipo);
                })
                .catch((error: ErroCep) => {
                    // Alguma coisa deu errado :/
                    console.log(error.message);
                });
        } else {
            alert('cep invalido');
        }
    }

    trataResultadoEndereco(endereco: Endereco, tipo) {
        /!*   if (tipo === 'cepLivro') {
            console.log('preencheu CEP');
            this.user.enderecoEntLivro = endereco.logradouro;
            this.user.complementoEntLivro = endereco.complemento;
            this.user.bairroEntLivro = endereco.bairro;
            this.user.cidadeEntLivro = endereco.localidade;
            this.user.ufEntLivro = endereco.uf;
            this.user.cepEntLivro = endereco.cep;
        } else *!/ if (
            tipo === 'cep'
        ) {
            this.user.enderecoLogradouro = endereco.logradouro;
            this.user.enderecoComplemento = endereco.complemento;
            this.user.enderecoBairro = endereco.bairro;
            this.user.enderecoCidade = endereco.localidade;
            this.user.enderecoUf = endereco.uf;
            this.user.cep = endereco.cep;
            console.log('preencheu CEP LIVRO');
        }
    }

    trim(strTexto) {
        // Substitúi os espaços vazios no inicio e no fim da string por vazio.
        return strTexto.replace(/^s+|s+$/g, '');
    }

    // Função para validação de CEP.
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
    }*!/

    status() {
        if (this.user.id === null) {
            this.user.activated = true;
        }
    }

    previousState() {
        window.history.back();
    }

    private onSaveSuccess(result) {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    isNullOrUndefined(object) {
        if (!object || object === undefined || object === null) {
            return true;
        }
        return false;
    }*/
}
