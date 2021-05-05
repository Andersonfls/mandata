import { Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { DashboardComponent } from './dashboard.component';

export const dashboardRoute: Routes = [
    {
        path: 'dashboard',
        component: DashboardComponent,
        data: {
            authorities: ['ROLE_USER', 'PROFESSOR'],
            pageTitle: 'cetebApp.dashboard.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];
