import { Component, OnInit } from '@angular/core';
import {RegistrationService} from './registration.service';
import {User} from './user.model';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  newUser:User;

  constructor(
    private registrationService: RegistrationService
  ) { }

  ngOnInit() {
  }

  onSubmit(): void {
    this.registrationService.register(this.newUser);
  }

}
