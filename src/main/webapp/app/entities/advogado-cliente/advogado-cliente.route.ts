import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { AdvogadoCliente } from 'app/shared/model/advogado-cliente.model';
import { AdvogadoClienteService } from './advogado-cliente.service';
import { AdvogadoClienteComponent } from './advogado-cliente.component';
import { AdvogadoClienteDetailComponent } from './advogado-cliente-detail.component';
import { AdvogadoClienteUpdateComponent } from './advogado-cliente-update.component';
import { AdvogadoClienteDeletePopupComponent } from './advogado-cliente-delete-dialog.component';
import { IAdvogadoCliente } from 'app/shared/model/advogado-cliente.model';

@Injectable({ providedIn: 'root' })
export class AdvogadoClienteResolve implements Resolve<IAdvogadoCliente> {
    constructor(private service: AdvogadoClienteService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IAdvogadoCliente> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<AdvogadoCliente>) => response.ok),
                map((advogado_cliente: HttpResponse<AdvogadoCliente>) => advogado_cliente.body)
            );
        }
        return of(new AdvogadoCliente());
    }
}

export const advogadoClienteRoute: Routes = [
    {
        path: '',
        component: AdvogadoClienteComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado_cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: AdvogadoClienteDetailComponent,
        resolve: {
            advogado_cliente: AdvogadoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado_cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: AdvogadoClienteUpdateComponent,
        resolve: {
            advogado_cliente: AdvogadoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado_cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: AdvogadoClienteUpdateComponent,
        resolve: {
            advogado_cliente: AdvogadoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado_cliente.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const advogado_clientePopupRoute: Routes = [
    {
        path: ':id/delete',
        component: AdvogadoClienteDeletePopupComponent,
        resolve: {
            advogado_cliente: AdvogadoClienteResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado_cliente.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
