import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    TribunalComponent,
    TribunalDetailComponent,
    TribunalUpdateComponent,
    TribunalDeletePopupComponent,
    TribunalDeleteDialogComponent,
    tribunalRoute,
    tribunalPopupRoute
} from './';

const ENTITY_STATES = [...tribunalRoute, ...tribunalPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TribunalComponent,
        TribunalDetailComponent,
        TribunalUpdateComponent,
        TribunalDeleteDialogComponent,
        TribunalDeletePopupComponent
    ],
    entryComponents: [TribunalComponent, TribunalUpdateComponent, TribunalDeleteDialogComponent, TribunalDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataTribunalModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
