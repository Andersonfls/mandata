import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../core/auth/account.service';

@Component({
    selector: 'jhi-sidebar',
    templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
    isCollapsed: boolean;
    isCollapsed2: boolean;
    isCollapsed3: boolean;
    isCollapsed4: boolean;

    constructor(private accountService: AccountService) {}

    ngOnInit() {
        this.isCollapsed = true;
        this.isCollapsed2 = true;
        this.isCollapsed3 = true;
        this.isCollapsed4 = true;
    }

    isAuthenticated() {
        return this.accountService.isAuthenticated();
    }
}
