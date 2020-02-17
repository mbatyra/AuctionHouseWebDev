import {Component, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {BidDto} from './bid.model';
import {BidService} from './bid.service';

@Component({
  selector: 'app-bid',
  templateUrl: './bid.component.html',
  styleUrls: ['./bid.component.sass']
})
export class BidComponent implements OnInit {

  loader: Subscription;
  bids: BidDto[] = [];
  displayedColumns = ['Auction Description', 'Bid Price'];
  constructor(
    private bidService: BidService
  ) { }

  ngOnInit() {
    this.getData();
  }

  private getData(){
    this.loader = this.bidService.getBidList().subscribe(data => {
      this.bids = data;
    });
  }

}
