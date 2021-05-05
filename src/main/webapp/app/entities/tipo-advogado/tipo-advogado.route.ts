import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TipoAdvogado } from 'app/shared/model/tipo-advogado.model';
import { TipoAdvogadoService } from './tipo-advogado.service';
import { TipoAdvogadoComponent } from './tipo-advogado.component';
import { TipoAdvogadoDetailComponent } from './tipo-advogado-detail.component';
import { TipoAdvogadoUpdateComponent } from './tipo-advogado-update.component';
import { TipoAdvogadoDeletePopupComponent } from './tipo-advogado-delete-dialog.component';
import { ITipoAdvogado } from 'app/shared/model/tipo-advogado.model';

@Injectable({ providedIn: 'root' })
export class TipoAdvogadoResolve implements Resolve<ITipoAdvogado> {
    constructor(private service: TipoAdvogadoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITipoAdvogado> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TipoAdvogado>) => response.ok),
                map((tipoAdvogado: HttpResponse<TipoAdvogado>) => tipoAdvogado.body)
            );
        }
        return of(new TipoAdvogado());
    }
}

export const tipoAdvogadoRoute: Routes = [
    {
        path: '',
        component: TipoAdvogadoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tipoAdvogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TipoAdvogadoDetailComponent,
        resolve: {
            tipoAdvogado: TipoAdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoAdvogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TipoAdvogadoUpdateComponent,
        resolve: {
            tipoAdvogado: TipoAdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoAdvogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TipoAdvogadoUpdateComponent,
        resolve: {
            tipoAdvogado: TipoAdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoAdvogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tipoAdvogadoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TipoAdvogadoDeletePopupComponent,
        resolve: {
            tipoAdvogado: TipoAdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoAdvogado.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
