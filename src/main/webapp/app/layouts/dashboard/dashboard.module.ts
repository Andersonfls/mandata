import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';
import { dashboardRoute } from './dashboard.route';
import { DashboardComponent } from './dashboard.component';
import { MandataSharedModule } from '../../shared/shared.module';

const ENTITY_STATES = [...dashboardRoute];

@NgModule({
    imports: [MandataSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [DashboardComponent],
    entryComponents: [DashboardComponent],
    providers: [
        {
            provide: JhiLanguageService,
            useClass: JhiLanguageService
        }
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataDashboardModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
