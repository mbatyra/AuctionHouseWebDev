import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BidDto} from './bid.model';

@Injectable({
  providedIn: 'root'
})
export class BidService {

  constructor(
    protected http: HttpClient,
  ) { }

  getBidList(): Observable<BidDto[]> {
    return this.http.get<BidDto[]>('http://localhost:8095/user/bid');
  }

  addBid(data: BidDto) {
    return this.http.post<{ id: number }>('http://localhost:8095/user/bid/create', data);
  }
}
