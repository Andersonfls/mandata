import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TipoAdvogadoComponent,
    TipoAdvogadoDetailComponent,
    TipoAdvogadoUpdateComponent,
    TipoAdvogadoDeletePopupComponent,
    TipoAdvogadoDeleteDialogComponent,
    tipoAdvogadoRoute,
    tipoAdvogadoPopupRoute
} from './';

const ENTITY_STATES = [...tipoAdvogadoRoute, ...tipoAdvogadoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TipoAdvogadoComponent,
        TipoAdvogadoDetailComponent,
        TipoAdvogadoUpdateComponent,
        TipoAdvogadoDeleteDialogComponent,
        TipoAdvogadoDeletePopupComponent
    ],
    entryComponents: [
        TipoAdvogadoComponent,
        TipoAdvogadoUpdateComponent,
        TipoAdvogadoDeleteDialogComponent,
        TipoAdvogadoDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTipoAdvogadoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
