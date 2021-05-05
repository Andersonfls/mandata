import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TabelaEventoComponent,
    TabelaEventoDetailComponent,
    TabelaEventoUpdateComponent,
    TabelaEventoDeletePopupComponent,
    TabelaEventoDeleteDialogComponent,
    tabelaEventoRoute,
    tabelaEventoPopupRoute
} from './';

const ENTITY_STATES = [...tabelaEventoRoute, ...tabelaEventoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TabelaEventoComponent,
        TabelaEventoDetailComponent,
        TabelaEventoUpdateComponent,
        TabelaEventoDeleteDialogComponent,
        TabelaEventoDeletePopupComponent
    ],
    entryComponents: [
        TabelaEventoComponent,
        TabelaEventoUpdateComponent,
        TabelaEventoDeleteDialogComponent,
        TabelaEventoDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTabelaEventoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
