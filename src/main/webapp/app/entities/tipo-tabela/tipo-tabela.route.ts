import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TipoTabela } from 'app/shared/model/tipo-tabela.model';
import { TipoTabelaService } from './tipo-tabela.service';
import { TipoTabelaComponent } from './tipo-tabela.component';
import { TipoTabelaDetailComponent } from './tipo-tabela-detail.component';
import { TipoTabelaUpdateComponent } from './tipo-tabela-update.component';
import { TipoTabelaDeletePopupComponent } from './tipo-tabela-delete-dialog.component';
import { ITipoTabela } from 'app/shared/model/tipo-tabela.model';

@Injectable({ providedIn: 'root' })
export class TipoTabelaResolve implements Resolve<ITipoTabela> {
    constructor(private service: TipoTabelaService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITipoTabela> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TipoTabela>) => response.ok),
                map((tipoTabela: HttpResponse<TipoTabela>) => tipoTabela.body)
            );
        }
        return of(new TipoTabela());
    }
}

export const tipoTabelaRoute: Routes = [
    {
        path: '',
        component: TipoTabelaComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tipoTabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TipoTabelaDetailComponent,
        resolve: {
            tipoTabela: TipoTabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoTabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TipoTabelaUpdateComponent,
        resolve: {
            tipoTabela: TipoTabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoTabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TipoTabelaUpdateComponent,
        resolve: {
            tipoTabela: TipoTabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoTabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tipoTabelaPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TipoTabelaDeletePopupComponent,
        resolve: {
            tipoTabela: TipoTabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tipoTabela.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
