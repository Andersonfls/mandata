import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';
import { MandataSharedModule } from 'app/shared';
import { NgxMaskModule } from 'ngx-mask';
import { NgxViacepModule } from '@brunoc/ngx-viacep';
import { TabsModule } from 'ngx-tabs';
import { TextMaskModule } from 'angular2-text-mask';
import { NgxCurrencyModule } from 'ngx-currency';
import { AlunoComponent, AlunoUpdateComponent, AlunoDetailComponent, AlunoDeleteDialogComponent, alunoRoute } from './';

@NgModule({
    imports: [
        MandataSharedModule,
        RouterModule.forChild(alunoRoute),
        NgxMaskModule.forRoot(),
        NgxViacepModule,
        TabsModule,
        TextMaskModule,
        NgxCurrencyModule
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [AlunoComponent, AlunoUpdateComponent, AlunoDetailComponent, AlunoDeleteDialogComponent],
    entryComponents: [AlunoComponent, AlunoUpdateComponent, AlunoDetailComponent, AlunoDeleteDialogComponent],
    providers: [
        {
            provide: JhiLanguageService,
            useClass: JhiLanguageService
        }
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataAlunoModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
