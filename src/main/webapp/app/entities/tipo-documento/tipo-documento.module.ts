import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TipoDocumentoComponent,
    TipoDocumentoDetailComponent,
    TipoDocumentoUpdateComponent,
    TipoDocumentoDeletePopupComponent,
    TipoDocumentoDeleteDialogComponent,
    tipoDocumentoRoute,
    tipoDocumentoPopupRoute
} from './';

const ENTITY_STATES = [...tipoDocumentoRoute, ...tipoDocumentoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TipoDocumentoComponent,
        TipoDocumentoDetailComponent,
        TipoDocumentoUpdateComponent,
        TipoDocumentoDeleteDialogComponent,
        TipoDocumentoDeletePopupComponent
    ],
    entryComponents: [
        TipoDocumentoComponent,
        TipoDocumentoUpdateComponent,
        TipoDocumentoDeleteDialogComponent,
        TipoDocumentoDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTipoDocumentoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
