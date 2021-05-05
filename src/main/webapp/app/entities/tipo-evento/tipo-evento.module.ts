import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TipoEventoComponent,
    TipoEventoDetailComponent,
    TipoEventoUpdateComponent,
    TipoEventoDeletePopupComponent,
    TipoEventoDeleteDialogComponent,
    tipoEventoRoute,
    tipoEventoPopupRoute
} from './';

const ENTITY_STATES = [...tipoEventoRoute, ...tipoEventoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TipoEventoComponent,
        TipoEventoDetailComponent,
        TipoEventoUpdateComponent,
        TipoEventoDeleteDialogComponent,
        TipoEventoDeletePopupComponent
    ],
    entryComponents: [TipoEventoComponent, TipoEventoUpdateComponent, TipoEventoDeleteDialogComponent, TipoEventoDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTipoEventoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
