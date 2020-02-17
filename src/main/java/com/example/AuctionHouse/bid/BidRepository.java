package com.example.AuctionHouse.bid;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findAllByAuctionIdOrderByBidPriceAsc(Long auctionId);
}
