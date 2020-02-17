import { Component, OnInit } from '@angular/core';
import {AuctionService} from './auction.service';
import {AuctionDto} from './auction.model';
import {Subscription} from 'rxjs';
import {MatDialog} from '@angular/material';
import {AuctionDialogComponent} from '../auction-dialog/auction-dialog.component';
import {BidService} from '../bid/bid.service';

@Component({
  selector: 'app-auction',
  templateUrl: './auction.component.html',
  styleUrls: ['./auction.component.css']
})
export class AuctionComponent implements OnInit {

  loader: Subscription;
  auctions: AuctionDto[] = [];
  displayedColumns = ['Description', 'Actual Price', 'Buy Out Price'];
  constructor(
    public dialog: MatDialog,
    private auctionService: AuctionService,
    private bidService: BidService,
  ) { }

  ngOnInit() {
    this.getData();
  }

  private getData(){
    this.loader = this.auctionService.getAuctionsList().subscribe(data => {
      this.auctions = data;
    });
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(AuctionDialogComponent, {
      width: '600px',
      data: 'Add Post'
    });
    dialogRef.componentInstance.event.subscribe((result) => {
      this.auctionService.addAuction(result.data);
      this.getData();
    });
  }

  bidDialog() {
    let dialogRef = this.dialog.open(AuctionDialogComponent, {
      width: '600px',
      data: 'Add Bid'
    });
    dialogRef.componentInstance.event.subscribe((result) => {
      this.bidService.addBid(result.data);
      this.getData();
    });
  }
}
