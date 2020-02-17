package com.example.AuctionHouse.auction;

import com.example.AuctionHouse.bid.Bid;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDTO {

    private Long id;
    private String description;
    private boolean accepted;
    private Long startPrice;
    private Long actualPrice;
    private Long buyOutPrice;
    private Long userId;
//    List<Bid> bids;

//    private List<Bid> bids = new ArrayList<>();
}
