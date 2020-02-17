package com.example.AuctionHouse.bid;

import com.example.AuctionHouse.auction.Auction;
import com.example.AuctionHouse.auction.AuctionDTO;
import com.example.AuctionHouse.auction.AuctionRepository;
import com.example.AuctionHouse.auction.AuctionService;
import com.example.AuctionHouse.user.User;
import com.example.AuctionHouse.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BidService {

    private final BidRepository bidRepository;
    private final UserRepository userRepository;
    private final AuctionRepository auctionRepository;

    public ResponseEntity<String> create(BidDTO bidDTO) {

        User user = userRepository.getOne(bidDTO.getUserId());

        Auction auction = auctionRepository.getOne(bidDTO.getAuctionId());

        if( bidDTO.getBidPrice() >= auction.getBuyOutPrice()){

            auction.setActualPrice(bidDTO.getBidPrice());
            auction.setAccepted(true);


            Bid bid = Bid.builder()
                    .bidPrice(bidDTO.getBidPrice())
                    .user(user)
                    .auction(auction)
                    .build();

            bidRepository.save(bid);

            return new ResponseEntity<>("Auction buy out!", HttpStatus.OK);

        }

        if(bidDTO.getBidPrice() >= auction.getActualPrice()){

            auction.setActualPrice(bidDTO.getBidPrice());

            Bid bid = Bid.builder()
                    .bidPrice(bidDTO.getBidPrice())
                    .user(user)
                    .auction(auction)
                    .build();

            bidRepository.save(bid);

            return new ResponseEntity<>("Bid added", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Bid is to low", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    public List<BidDTO> getBidsFromAuction(Long auctionId) {
        List<Bid> bids = bidRepository.findAllByAuctionIdOrderByBidPriceAsc(auctionId);
        return bids.stream().map(Bid::toDto).collect(Collectors.toList());
    }

    public BidDTO getHighestBid(Long auctionId) {
        List<Bid> bids = bidRepository.findAllByAuctionIdOrderByBidPriceAsc(auctionId);
        return bids.get(0).toDto();
    }

    public BidDTO get(Long id) {
        Bid bid = bidRepository.getOne(id);
        return bid.toDto();
    }

    public List<BidDTO> getAll() {
        List<Bid> bids = bidRepository.findAll();
        return  bids.stream().map(Bid::toDto).collect(Collectors.toList());
    }

}
