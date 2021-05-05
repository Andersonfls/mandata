import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TipoClienteComponent,
    TipoClienteDetailComponent,
    TipoClienteUpdateComponent,
    TipoClienteDeletePopupComponent,
    TipoClienteDeleteDialogComponent,
    tipoClienteRoute,
    tipoClientePopupRoute
} from './';

const ENTITY_STATES = [...tipoClienteRoute, ...tipoClientePopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TipoClienteComponent,
        TipoClienteDetailComponent,
        TipoClienteUpdateComponent,
        TipoClienteDeleteDialogComponent,
        TipoClienteDeletePopupComponent
    ],
    entryComponents: [TipoClienteComponent, TipoClienteUpdateComponent, TipoClienteDeleteDialogComponent, TipoClienteDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTipoClienteModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
