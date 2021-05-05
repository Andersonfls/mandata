import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../core/auth/account.service';

@Component({
    selector: 'jhi-footer',
    templateUrl: './footer.component.html'
})
export class FooterComponent implements OnInit {
    account: Account;

    constructor(private accountService: AccountService) {}

    ngOnInit() {}

    isAuthenticated() {
        return this.accountService.isAuthenticated();
    }
}
