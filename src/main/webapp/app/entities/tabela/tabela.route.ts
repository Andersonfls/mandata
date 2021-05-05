import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Tabela } from 'app/shared/model/tabela.model';
import { TabelaService } from './tabela.service';
import { TabelaComponent } from './tabela.component';
import { TabelaDetailComponent } from './tabela-detail.component';
import { TabelaUpdateComponent } from './tabela-update.component';
import { TabelaDeletePopupComponent } from './tabela-delete-dialog.component';
import { ITabela } from 'app/shared/model/tabela.model';

@Injectable({ providedIn: 'root' })
export class TabelaResolve implements Resolve<ITabela> {
    constructor(private service: TabelaService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITabela> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Tabela>) => response.ok),
                map((tabela: HttpResponse<Tabela>) => tabela.body)
            );
        }
        return of(new Tabela());
    }
}

export const tabelaRoute: Routes = [
    {
        path: '',
        component: TabelaComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TabelaDetailComponent,
        resolve: {
            tabela: TabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TabelaUpdateComponent,
        resolve: {
            tabela: TabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TabelaUpdateComponent,
        resolve: {
            tabela: TabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabela.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tabelaPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TabelaDeletePopupComponent,
        resolve: {
            tabela: TabelaResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabela.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
