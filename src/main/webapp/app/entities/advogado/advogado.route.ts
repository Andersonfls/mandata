import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Advogado } from 'app/shared/model/advogado.model';
import { AdvogadoService } from './advogado.service';
import { AdvogadoComponent } from './advogado.component';
import { AdvogadoDetailComponent } from './advogado-detail.component';
import { AdvogadoUpdateComponent } from './advogado-update.component';
import { AdvogadoDeletePopupComponent } from './advogado-delete-dialog.component';
import { IAdvogado } from 'app/shared/model/advogado.model';

@Injectable({ providedIn: 'root' })
export class AdvogadoResolve implements Resolve<IAdvogado> {
    constructor(private service: AdvogadoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IAdvogado> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Advogado>) => response.ok),
                map((advogado: HttpResponse<Advogado>) => advogado.body)
            );
        }
        return of(new Advogado());
    }
}

export const advogadoRoute: Routes = [
    {
        path: '',
        component: AdvogadoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.advogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: AdvogadoDetailComponent,
        resolve: {
            advogado: AdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: AdvogadoUpdateComponent,
        resolve: {
            advogado: AdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: AdvogadoUpdateComponent,
        resolve: {
            advogado: AdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const advogadoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: AdvogadoDeletePopupComponent,
        resolve: {
            advogado: AdvogadoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.advogado.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
