import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule} from 'app/shared';
import {
    UnidadeComponent,
    UnidadeDetailComponent,
    UnidadeUpdateComponent,
    UnidadeDeletePopupComponent,
    UnidadeDeleteDialogComponent,
    unidadeRoute,
    unidadePopupRoute
} from './';

const ENTITY_STATES = [...unidadeRoute, ...unidadePopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        UnidadeComponent,
        UnidadeDetailComponent,
        UnidadeUpdateComponent,
        UnidadeDeleteDialogComponent,
        UnidadeDeletePopupComponent
    ],
    entryComponents: [UnidadeComponent, UnidadeUpdateComponent, UnidadeDeleteDialogComponent, UnidadeDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataUnidadeModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
