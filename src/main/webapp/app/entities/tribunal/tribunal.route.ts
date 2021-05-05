import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Tribunal } from 'app/shared/model/tribunal.model';
import { TribunalService } from './tribunal.service';
import { TribunalComponent } from './tribunal.component';
import { TribunalDetailComponent } from './tribunal-detail.component';
import { TribunalUpdateComponent } from './tribunal-update.component';
import { TribunalDeletePopupComponent } from './tribunal-delete-dialog.component';
import { ITribunal } from 'app/shared/model/tribunal.model';

@Injectable({ providedIn: 'root' })
export class TribunalResolve implements Resolve<ITribunal> {
    constructor(private service: TribunalService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITribunal> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Tribunal>) => response.ok),
                map((tribunal: HttpResponse<Tribunal>) => tribunal.body)
            );
        }
        return of(new Tribunal());
    }
}

export const tribunalRoute: Routes = [
    {
        path: '',
        component: TribunalComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tribunal.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TribunalDetailComponent,
        resolve: {
            tribunal: TribunalResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tribunal.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TribunalUpdateComponent,
        resolve: {
            tribunal: TribunalResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tribunal.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TribunalUpdateComponent,
        resolve: {
            tribunal: TribunalResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tribunal.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tribunalPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TribunalDeletePopupComponent,
        resolve: {
            tribunal: TribunalResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tribunal.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
