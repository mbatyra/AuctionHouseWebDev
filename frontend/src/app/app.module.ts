import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BidComponent } from './bid/bid.component';
import { AuctionComponent } from './auction/auction.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule, MatDialogModule,
  MatIconModule, MatInputModule,
  MatListModule,
  MatMenuModule, MatSelectModule,
  MatSidenavModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {AuctionService} from './auction/auction.service';
import {HttpClientModule} from '@angular/common/http';
import { AuctionDialogComponent } from './auction-dialog/auction-dialog.component';
import {FormsModule} from '@angular/forms';
import { BidDialogComponent } from './bid-dialog/bid-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BidComponent,
    AuctionComponent,
    RegistrationFormComponent,
    AuctionDialogComponent,
    BidDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    FlexLayoutModule,
    MatTableModule,
    MatCardModule,
    HttpClientModule,
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    MatButtonModule,
  ],
  exports: [
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
  ],
  providers: [AuctionService],
  bootstrap: [AppComponent],
  entryComponents: [
    AuctionDialogComponent
  ]
})
export class AppModule { }
