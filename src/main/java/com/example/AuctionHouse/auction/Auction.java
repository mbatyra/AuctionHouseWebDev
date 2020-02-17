package com.example.AuctionHouse.auction;

import com.example.AuctionHouse.bid.Bid;
import com.example.AuctionHouse.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(generator = "auction_seq")
    private Long id;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @Column(name= "start_price", nullable = false)
    private Long startPrice;

    @Column(name= "actual_price", nullable = false)
    private Long actualPrice;

    @Column(name = "buy_out_price")
    private Long buyOutPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "auction")
    private List<Bid> bids;

    AuctionDTO toDTO(){
        return new AuctionDTO(id, description, accepted, startPrice, actualPrice, buyOutPrice, user.getId());
    }

    void accept(){
        this.accepted = true;
    }
}
