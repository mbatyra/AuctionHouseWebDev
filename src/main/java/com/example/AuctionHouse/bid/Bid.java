package com.example.AuctionHouse.bid;


import com.example.AuctionHouse.auction.Auction;
import com.example.AuctionHouse.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(generator = "bid_seq")
    private Long id;

    @Column(name = "bid_price", nullable = false)
    private Long bidPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    BidDTO toDto() {
        return new BidDTO(id, bidPrice, user.getId(), auction.getId());
    }
}
