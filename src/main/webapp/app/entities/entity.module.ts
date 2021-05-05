import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'cliente',
                loadChildren: './cliente/cliente.module#MandataClienteModule'
            },
            {
                path: 'tabela',
                loadChildren: './tabela/tabela.module#MandataTabelaModule'
            },
            {
                path: 'advogado',
                loadChildren: './advogado/advogado.module#MandataAdvogadoModule'
            },
            {
                path: 'tipo-advogado',
                loadChildren: './tipo-advogado/tipo-advogado.module#MandataTipoAdvogadoModule'
            },
            {
                path: 'escritorio',
                loadChildren: './escritorio/escritorio.module#MandataEscritorioModule'
            },
            {
                path: 'tipo-cliente',
                loadChildren: './tipo-cliente/tipo-cliente.module#MandataTipoClienteModule'
            },
            {
                path: 'tipo-evento',
                loadChildren: './tipo-evento/tipo-evento.module#MandataTipoEventoModule'
            },
            {
                path: 'tipo-tabela',
                loadChildren: './tipo-tabela/tipo-tabela.module#MandataTipoTabelaModule'
            },
            {
                path: 'unidade',
                loadChildren: './unidade/unidade.module#MandataUnidadeModule'
            },
            {
                path: 'area',
                loadChildren: './area/area.module#MandataAreaModule'
            },
            {
                path: 'risco',
                loadChildren: './risco/risco.module#MandataRiscoModule'
            },
            {
                path: 'tipo-documento',
                loadChildren: './tipo-documento/tipo-documento.module#MandataTipoDocumentoModule'
            },
            {
                path: 'tribunal',
                loadChildren: './tribunal/tribunal.module#MandataTribunalModule'
            }
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataEntityModule {}
