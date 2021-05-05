import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TabelaComponent,
    TabelaDetailComponent,
    TabelaUpdateComponent,
    TabelaDeletePopupComponent,
    TabelaDeleteDialogComponent,
    tabelaRoute,
    tabelaPopupRoute
} from './';

const ENTITY_STATES = [...tabelaRoute, ...tabelaPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [TabelaComponent, TabelaDetailComponent, TabelaUpdateComponent, TabelaDeleteDialogComponent, TabelaDeletePopupComponent],
    entryComponents: [TabelaComponent, TabelaUpdateComponent, TabelaDeleteDialogComponent, TabelaDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTabelaModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
