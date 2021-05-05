import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Risco } from 'app/shared/model/risco.model';
import { RiscoService } from './risco.service';
import { RiscoComponent } from './risco.component';
import { RiscoDetailComponent } from './risco-detail.component';
import { RiscoUpdateComponent } from './risco-update.component';
import { RiscoDeletePopupComponent } from './risco-delete-dialog.component';
import { IRisco } from 'app/shared/model/risco.model';

@Injectable({ providedIn: 'root' })
export class RiscoResolve implements Resolve<IRisco> {
    constructor(private service: RiscoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IRisco> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Risco>) => response.ok),
                map((risco: HttpResponse<Risco>) => risco.body)
            );
        }
        return of(new Risco());
    }
}

export const riscoRoute: Routes = [
    {
        path: '',
        component: RiscoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.risco.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: RiscoDetailComponent,
        resolve: {
            risco: RiscoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.risco.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: RiscoUpdateComponent,
        resolve: {
            risco: RiscoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.risco.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: RiscoUpdateComponent,
        resolve: {
            risco: RiscoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.risco.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const riscoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: RiscoDeletePopupComponent,
        resolve: {
            risco: RiscoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.risco.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
