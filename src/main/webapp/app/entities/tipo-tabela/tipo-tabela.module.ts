import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TipoTabelaComponent,
    TipoTabelaDetailComponent,
    TipoTabelaUpdateComponent,
    TipoTabelaDeletePopupComponent,
    TipoTabelaDeleteDialogComponent,
    tipoTabelaRoute,
    tipoTabelaPopupRoute
} from './';

const ENTITY_STATES = [...tipoTabelaRoute, ...tipoTabelaPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TipoTabelaComponent,
        TipoTabelaDetailComponent,
        TipoTabelaUpdateComponent,
        TipoTabelaDeleteDialogComponent,
        TipoTabelaDeletePopupComponent
    ],
    entryComponents: [TipoTabelaComponent, TipoTabelaUpdateComponent, TipoTabelaDeleteDialogComponent, TipoTabelaDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTipoTabelaModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
