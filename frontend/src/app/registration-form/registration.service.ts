import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './user.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(
    protected http: HttpClient,
  ) { }
  register(data: User) {
    return this.http.post('http://localhost:8095/registration', JSON.stringify(data));
  }
}
