import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TipoCliente } from 'app/shared/model/tipo-cliente.model';
import { TipoClienteService } from './tipo-cliente.service';
import { TipoClienteComponent } from './tipo-cliente.component';
import { TipoClienteDetailComponent } from './tipo-cliente-detail.component';
import { TipoClienteUpdateComponent } from './tipo-cliente-update.component';
import { TipoClienteDeletePopupComponent } from './tipo-cliente-delete-dialog.component';
import { ITipoCliente } from 'app/shared/model/tipo-cliente.model';

@Injectable({ providedIn: 'root' })
export class TipoClienteResolve implements Resolve<ITipoCliente> {
    constructor(private service: TipoClienteService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITipoCliente> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TipoCliente>) => response.ok),
                map((tipoCliente: HttpResponse<TipoCliente>) => tipoCliente.body)
            );
        }
        return of(new TipoCliente());
    }
}

export const tipoClienteRoute: Routes = [
    {
        path: '',
        component: TipoClienteComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tipoCliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TipoClienteDetailComponent,
        resolve: {
            tipoCliente: TipoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoCliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TipoClienteUpdateComponent,
        resolve: {
            tipoCliente: TipoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoCliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TipoClienteUpdateComponent,
        resolve: {
            tipoCliente: TipoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoCliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tipoClientePopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TipoClienteDeletePopupComponent,
        resolve: {
            tipoCliente: TipoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoCliente.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
