import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import {User, UserRouteAccessService, UserService} from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ClienteComponent } from './cliente.component';
import { ClienteDetailComponent } from './cliente-detail.component';
import { ClienteUpdateComponent } from './cliente-update.component';
import { ClienteDeletePopupComponent } from './cliente-delete-dialog.component';

@Injectable({ providedIn: 'root' })
export class ClienteResolve implements Resolve<User> {
    constructor(private service: UserService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<User> {
        const login = route.params['login'] ? route.params['login'] : null;
        if (login) {
            return this.service.find(login).pipe(
                filter((response: HttpResponse<User>) => response.ok),
                map((cliente: HttpResponse<User>) => cliente.body)
            );
        }
        return of(new User());
    }
}

export const clienteRoute: Routes = [
    {
        path: '',
        component: ClienteComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: ClienteDetailComponent,
        resolve: {
            cliente: ClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: ClienteUpdateComponent,
        resolve: {
            cliente: ClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: ClienteUpdateComponent,
        resolve: {
            cliente: ClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const clientePopupRoute: Routes = [
    {
        path: ':login/delete',
        component: ClienteDeletePopupComponent,
        resolve: {
            cliente: ClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.cliente.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
