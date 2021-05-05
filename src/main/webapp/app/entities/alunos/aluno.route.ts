import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { AccountService, User, UserService } from 'app/core';
import { AlunoComponent } from './aluno.component';
import { AlunoDetailComponent } from './aluno-detail.component';
import { AlunoUpdateComponent } from './aluno-update.component';

@Injectable({ providedIn: 'root' })
export class AlunoRoute implements CanActivate {
    constructor(private accountService: AccountService) {}

    canActivate() {
        return this.accountService.identity().then(account => this.accountService.hasAnyAuthority(['ROLE_ADMIN']));
    }
}

@Injectable({ providedIn: 'root' })
export class AlunoResolve implements Resolve<any> {
    constructor(private service: UserService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['login'] ? route.params['login'] : null;
        if (id) {
            return this.service.find(id);
        }
        return new User();
    }
}

export const alunoRoute: Routes = [
    {
        path: '',
        component: AlunoComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            pageTitle: 'userManagement.home.title',
            defaultSort: 'id,asc'
        }
    },
    {
        path: 'aluno/:login/view',
        component: AlunoDetailComponent,
        resolve: {
            user: AlunoResolve
        },
        data: {
            pageTitle: 'userManagement.home.title'
        }
    },
    {
        path: 'aluno/new',
        component: AlunoUpdateComponent,
        resolve: {
            user: AlunoResolve
        },
        data: {
            pageTitle: 'userManagement.home.title'
        }
    },
    {
        path: 'aluno/:login/edit',
        component: AlunoUpdateComponent,
        resolve: {
            user: AlunoResolve
        },
        data: {
            pageTitle: 'userManagement.home.title'
        }
    }
];
