import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Representado } from 'app/shared/model/representado.model';
import { RepresentadoService } from './representado.service';
import { RepresentadoComponent } from './representado.component';
import { RepresentadoDetailComponent } from './representado-detail.component';
import { RepresentadoUpdateComponent } from './representado-update.component';
import { RepresentadoDeletePopupComponent } from './representado-delete-dialog.component';
import { IRepresentado } from 'app/shared/model/representado.model';

@Injectable({ providedIn: 'root' })
export class RepresentadoResolve implements Resolve<IRepresentado> {
    constructor(private service: RepresentadoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IRepresentado> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Representado>) => response.ok),
                map((representado: HttpResponse<Representado>) => representado.body)
            );
        }
        return of(new Representado());
    }
}

export const representadoRoute: Routes = [
    {
        path: '',
        component: RepresentadoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.representado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: RepresentadoDetailComponent,
        resolve: {
            representado: RepresentadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.representado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: RepresentadoUpdateComponent,
        resolve: {
            representado: RepresentadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.representado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: RepresentadoUpdateComponent,
        resolve: {
            representado: RepresentadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.representado.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const representadoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: RepresentadoDeletePopupComponent,
        resolve: {
            representado: RepresentadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.representado.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
