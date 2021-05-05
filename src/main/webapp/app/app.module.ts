import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { Ng2Webstorage } from 'ngx-webstorage';
import { NgJhipsterModule } from 'ng-jhipster';

import { AuthInterceptor } from './blocks/interceptor/auth.interceptor';
import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import * as moment from 'moment';
import { TextMaskModule } from 'angular2-text-mask';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import {
    JhiMainComponent,
    NavbarComponent,
    SidebarComponent,
    FooterComponent,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from './layouts';
import { CKEditorModule } from 'ng2-ckeditor';
import { IConfig, NgxMaskModule } from 'ngx-mask';
import {MandataSharedModule} from 'app/shared';
import {MandataCoreModule} from 'app/core';
import {MandataEntityModule} from 'app/entities/entity.module';
import {MandataHomeModule} from 'app/home';
import {MandataDashboardModule} from 'app/layouts/dashboard/dashboard.module';
import {MandataAccountModule} from 'app/account/account.module';
import {MandataAppRoutingModule} from 'app/app-routing.module';

@NgModule({
    imports: [
        BrowserModule,
        TextMaskModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        NgJhipsterModule.forRoot({
            // set below to true to make alerts look like toast
            alertAsToast: false,
            alertTimeout: 5000,
            i18nEnabled: true,
            defaultI18nLang: 'pt-br'
        }),
        MandataSharedModule.forRoot(),
        NgxMaskModule.forRoot(),
        MandataCoreModule,
        MandataDashboardModule,
        MandataHomeModule,
        MandataAccountModule,
        FontAwesomeModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
        MandataEntityModule,
        MandataAppRoutingModule,
        CKEditorModule
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        SidebarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true
        }
    ],
    bootstrap: [JhiMainComponent]
})
export class MandataAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
    }
}
