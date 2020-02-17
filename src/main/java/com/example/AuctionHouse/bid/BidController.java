package com.example.AuctionHouse.bid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/bid")
public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createBid(@RequestBody BidDTO BidDTO) throws  Exception {
        return bidService.create(BidDTO);
    }

    @GetMapping("/{id}")
    public BidDTO getBid(@PathVariable Long id) throws Exception {
        return bidService.get(id);
    }

    @GetMapping("/{auctionId}")
    public List<BidDTO> getBidsFromAuction(@PathVariable Long auctionId) throws Exception {
        return bidService.getBidsFromAuction(auctionId);
    }

    @GetMapping("/{auctionId}/highest")
    public BidDTO getHighestBid(@PathVariable Long auctionId) throws Exception {
        return bidService.getHighestBid(auctionId);
    }

    @CrossOrigin
    @GetMapping()
    public List<BidDTO> getAllAuction() throws Exception {
        return bidService.getAll();
    }
    
}
