import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../registration-form/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    protected http: HttpClient,
  ) { }
  login(data: User) {
    return this.http.post('http://localhost:8095/login', JSON.stringify(data));
  }
}
