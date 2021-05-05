import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { MandataSharedModule} from 'app/shared';
import {
    AdvogadoComponent,
    AdvogadoDetailComponent,
    AdvogadoUpdateComponent,
    AdvogadoDeletePopupComponent,
    AdvogadoDeleteDialogComponent,
    advogadoRoute,
    advogadoPopupRoute
} from './';
import {NgxMaskModule} from 'ngx-mask';

const ENTITY_STATES = [...advogadoRoute, ...advogadoPopupRoute];

@NgModule({
    imports: [MandataSharedModule, NgxMaskModule.forRoot(), RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AdvogadoComponent,
        AdvogadoDetailComponent,
        AdvogadoUpdateComponent,
        AdvogadoDeleteDialogComponent,
        AdvogadoDeletePopupComponent
    ],
    entryComponents: [AdvogadoComponent, AdvogadoUpdateComponent, AdvogadoDeleteDialogComponent, AdvogadoDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataAdvogadoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
