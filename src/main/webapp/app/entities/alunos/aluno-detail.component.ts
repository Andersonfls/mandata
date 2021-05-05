import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'app/core';

@Component({
    selector: 'jhi-aluno-detail',
    templateUrl: './aluno-detail.component.html'
})
export class AlunoDetailComponent implements OnInit {
    /*Objetos*/
    user: User;

    constructor(private route: ActivatedRoute) {}

    ngOnInit() {
        this.route.data.subscribe(({ user }) => {
            this.user = user.body ? user.body : user;
        });
    }
}
