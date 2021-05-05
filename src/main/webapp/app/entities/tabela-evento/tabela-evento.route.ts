import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { TabelaEvento } from 'app/shared/model/tabela-evento.model';
import { TabelaEventoService } from './tabela-evento.service';
import { TabelaEventoComponent } from './tabela-evento.component';
import { TabelaEventoDetailComponent } from './tabela-evento-detail.component';
import { TabelaEventoUpdateComponent } from './tabela-evento-update.component';
import { TabelaEventoDeletePopupComponent } from './tabela-evento-delete-dialog.component';
import { ITabelaEvento } from 'app/shared/model/tabela-evento.model';

@Injectable({ providedIn: 'root' })
export class TabelaEventoResolve implements Resolve<ITabelaEvento> {
    constructor(private service: TabelaEventoService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ITabelaEvento> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<TabelaEvento>) => response.ok),
                map((tabelaEvento: HttpResponse<TabelaEvento>) => tabelaEvento.body)
            );
        }
        return of(new TabelaEvento());
    }
}

export const tabelaEventoRoute: Routes = [
    {
        path: '',
        component: TabelaEventoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'cetebApp.tabelaEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: TabelaEventoDetailComponent,
        resolve: {
            tabelaEvento: TabelaEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabelaEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: TabelaEventoUpdateComponent,
        resolve: {
            tabelaEvento: TabelaEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabelaEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: TabelaEventoUpdateComponent,
        resolve: {
            tabelaEvento: TabelaEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabelaEvento.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tabelaEventoPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: TabelaEventoDeletePopupComponent,
        resolve: {
            tabelaEvento: TabelaEventoResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'cetebApp.tabelaEvento.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
