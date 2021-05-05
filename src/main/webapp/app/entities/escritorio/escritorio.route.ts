import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Escritorio } from 'app/shared/model/escritorio.model';
import { EscritorioService } from './escritorio.service';
import { EscritorioComponent } from './escritorio.component';
import { EscritorioDetailComponent } from './escritorio-detail.component';
import { EscritorioUpdateComponent } from './escritorio-update.component';
import { EscritorioDeletePopupComponent } from './escritorio-delete-dialog.component';
import { IEscritorio } from 'app/shared/model/escritorio.model';

@Injectable({ providedIn: 'root' })
export class EscritorioResolve implements Resolve<IEscritorio> {
    constructor(private service: EscritorioService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IEscritorio> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Escritorio>) => response.ok),
                map((escritorio: HttpResponse<Escritorio>) => escritorio.body)
            );
        }
        return of(new Escritorio());
    }
}

export const escritorioRoute: Routes = [
    {
        path: '',
        component: EscritorioComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.escritorio.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: EscritorioDetailComponent,
        resolve: {
            escritorio: EscritorioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.escritorio.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: EscritorioUpdateComponent,
        resolve: {
            escritorio: EscritorioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.escritorio.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: EscritorioUpdateComponent,
        resolve: {
            escritorio: EscritorioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.escritorio.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const escritorioPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: EscritorioDeletePopupComponent,
        resolve: {
            escritorio: EscritorioResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.escritorio.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
