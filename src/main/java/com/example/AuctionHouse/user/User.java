package com.example.AuctionHouse.user;

import com.example.AuctionHouse.auction.Auction;
import com.example.AuctionHouse.bid.Bid;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
public class User {

    @Id
    @GeneratedValue(generator = "users_seq")
    private Long id;

    @Column(name = "login", length = 50, nullable = false)
    private String login;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Auction> auctions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Bid> bids = new ArrayList<>();

    public User(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

}
