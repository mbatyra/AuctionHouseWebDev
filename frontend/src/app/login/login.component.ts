import {Component, OnInit} from '@angular/core';
import {User} from '../registration-form/user.model';
import {LoginService} from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User;

  constructor(
    private loginService: LoginService
  ) { }

  ngOnInit() {
  }

  login(): void {
    this.loginService.login(this.user);
  }

}
