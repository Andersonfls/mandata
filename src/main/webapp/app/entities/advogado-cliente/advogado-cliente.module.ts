import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    AdvogadoClienteComponent,
    AdvogadoClienteDetailComponent,
    AdvogadoClienteUpdateComponent,
    AdvogadoClienteDeletePopupComponent,
    AdvogadoClienteDeleteDialogComponent,
    advogadoClienteRoute,
    advogado_clientePopupRoute
} from './';

const ENTITY_STATES = [...advogadoClienteRoute, ...advogado_clientePopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AdvogadoClienteComponent,
        AdvogadoClienteDetailComponent,
        AdvogadoClienteUpdateComponent,
        AdvogadoClienteDeleteDialogComponent,
        AdvogadoClienteDeletePopupComponent
    ],
    entryComponents: [
        AdvogadoClienteComponent,
        AdvogadoClienteUpdateComponent,
        AdvogadoClienteDeleteDialogComponent,
        AdvogadoClienteDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataAdvogadoClienteModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
