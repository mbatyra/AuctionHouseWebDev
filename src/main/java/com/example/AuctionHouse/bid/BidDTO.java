package com.example.AuctionHouse.bid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidDTO {

    private Long id;
    private Long bidPrice;
    private Long userId;
    private Long auctionId;

}
