import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuctionComponent} from './auction/auction.component';
import {AppComponent} from './app.component';
import {BidComponent} from './bid/bid.component';
import {RegistrationFormComponent} from './registration-form/registration-form.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: 'auctions', component: AuctionComponent},
  {path: 'bids', component: BidComponent},
  {path: 'register', component: RegistrationFormComponent},
  {path: 'login', component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
