import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TipoEvento } from 'app/shared/model/tipo-evento.model';
import { TipoEventoService } from './tipo-evento.service';
import { TipoEventoComponent } from './tipo-evento.component';
import { TipoEventoDetailComponent } from './tipo-evento-detail.component';
import { TipoEventoUpdateComponent } from './tipo-evento-update.component';
import { TipoEventoDeletePopupComponent } from './tipo-evento-delete-dialog.component';
import { ITipoEvento } from 'app/shared/model/tipo-evento.model';

@Injectable({ providedIn: 'root' })
export class TipoEventoResolve implements Resolve<ITipoEvento> {
    constructor(private service: TipoEventoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITipoEvento> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TipoEvento>) => response.ok),
                map((tipoEvento: HttpResponse<TipoEvento>) => tipoEvento.body)
            );
        }
        return of(new TipoEvento());
    }
}

export const tipoEventoRoute: Routes = [
    {
        path: '',
        component: TipoEventoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tipoEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TipoEventoDetailComponent,
        resolve: {
            tipoEvento: TipoEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TipoEventoUpdateComponent,
        resolve: {
            tipoEvento: TipoEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TipoEventoUpdateComponent,
        resolve: {
            tipoEvento: TipoEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tipoEventoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TipoEventoDeletePopupComponent,
        resolve: {
            tipoEvento: TipoEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoEvento.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
