import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule } from 'app/shared';
import {
    RepresentadoComponent,
    RepresentadoDetailComponent,
    RepresentadoUpdateComponent,
    RepresentadoDeletePopupComponent,
    RepresentadoDeleteDialogComponent,
    representadoRoute,
    representadoPopupRoute
} from './';

const ENTITY_STATES = [...representadoRoute, ...representadoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        RepresentadoComponent,
        RepresentadoDetailComponent,
        RepresentadoUpdateComponent,
        RepresentadoDeleteDialogComponent,
        RepresentadoDeletePopupComponent
    ],
    entryComponents: [
        RepresentadoComponent,
        RepresentadoUpdateComponent,
        RepresentadoDeleteDialogComponent,
        RepresentadoDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataRepresentadoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
