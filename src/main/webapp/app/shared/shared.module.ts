import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import {JhiLoginModalComponent, HasAnyAuthorityDirective, MandataSharedLibsModule, MandataSharedCommonModule} from './';

@NgModule({
    imports: [MandataSharedLibsModule, MandataSharedCommonModule],
    declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [
        {
            provide: NgbDateAdapter,
            useClass: NgbDateMomentAdapter
        }
    ],
    entryComponents: [JhiLoginModalComponent],
    exports: [MandataSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MandataSharedModule {
    static forRoot() {
        return {
            ngModule: MandataSharedModule
        };
    }
}
