import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    RiscoComponent,
    RiscoDetailComponent,
    RiscoUpdateComponent,
    RiscoDeletePopupComponent,
    RiscoDeleteDialogComponent,
    riscoRoute,
    riscoPopupRoute
} from './';

const ENTITY_STATES = [...riscoRoute, ...riscoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [RiscoComponent, RiscoDetailComponent, RiscoUpdateComponent, RiscoDeleteDialogComponent, RiscoDeletePopupComponent],
    entryComponents: [RiscoComponent, RiscoUpdateComponent, RiscoDeleteDialogComponent, RiscoDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataRiscoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
