import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {AuctionDto} from './auction.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuctionService {

  constructor(
    protected http: HttpClient,
  ) { }

  getAuctionsList(): Observable<AuctionDto[]> {
    return this.http.get<AuctionDto[]>('http://localhost:8095/user/auction');
  }

  addAuction(data: AuctionDto) {
    return this.http.post<{ id: number }>('http://localhost:8095/user/auction/create', data);
  }
}
