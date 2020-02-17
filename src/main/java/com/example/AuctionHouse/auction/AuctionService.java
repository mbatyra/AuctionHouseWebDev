package com.example.AuctionHouse.auction;

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
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;

    public ResponseEntity<String> create(AuctionDTO auctionDTO) {

        User user = userRepository.getOne(auctionDTO.getUserId());

        Auction auction = Auction.builder()
                .description(auctionDTO.getDescription())
                .startPrice(auctionDTO.getStartPrice())
                .actualPrice(auctionDTO.getStartPrice())
                .buyOutPrice(auctionDTO.getBuyOutPrice())
                .user(user)
                .build();

        auctionRepository.save(auction);

        return new ResponseEntity<>("Auction created", HttpStatus.OK);

    }

    public ResponseEntity<String> edit(AuctionDTO auctionDTO) {

        //if bids = 1 not avaible

        Auction auction = auctionRepository.getOne(auctionDTO.getId());
        auction.setDescription(auctionDTO.getDescription());
        auction.setStartPrice(auctionDTO.getStartPrice());
        auction.setActualPrice(auctionDTO.getStartPrice());
        auction.setBuyOutPrice(auctionDTO.getBuyOutPrice());

        return new ResponseEntity<>("Auction edited", HttpStatus.OK);

    }

    public AuctionDTO get(Long id) {
        Auction auction = auctionRepository.getOne(id);
        return  auction.toDTO();
    }

    public List<AuctionDTO> getAll() {
        List<Auction> auctions = auctionRepository.findAll();
        return  auctions.stream().map(Auction::toDTO).collect(Collectors.toList());
    }

    public ResponseEntity<String> delete(Long id) throws Exception {
        auctionRepository.deleteById(id);
        return new ResponseEntity<>("Auction deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> accept(Long id) throws Exception {
        Auction auction = auctionRepository.findById(id)
                .orElseThrow(() ->new Exception("Auction not found!"));
        auction.accept();

        return new ResponseEntity<>("Auction accepted", HttpStatus.OK);
    }
}
