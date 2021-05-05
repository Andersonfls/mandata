import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    EscritorioComponent,
    EscritorioDetailComponent,
    EscritorioUpdateComponent,
    EscritorioDeletePopupComponent,
    EscritorioDeleteDialogComponent,
    escritorioRoute,
    escritorioPopupRoute
} from './';
import {NgxMaskModule} from 'ngx-mask';

const ENTITY_STATES = [...escritorioRoute, ...escritorioPopupRoute];

@NgModule({
    imports: [MandataSharedModule, NgxMaskModule.forRoot(), RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        EscritorioComponent,
        EscritorioDetailComponent,
        EscritorioUpdateComponent,
        EscritorioDeleteDialogComponent,
        EscritorioDeletePopupComponent
    ],
    entryComponents: [EscritorioComponent, EscritorioUpdateComponent, EscritorioDeleteDialogComponent, EscritorioDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataEscritorioModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
