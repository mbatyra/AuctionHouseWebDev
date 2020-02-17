package com.example.AuctionHouse.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/auction")
public class AuctionController {

    private AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAuction(@RequestBody AuctionDTO auctionDTO) throws  Exception {
        return auctionService.create(auctionDTO);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editAuction(@RequestBody AuctionDTO auctionDTO) throws  Exception {
        return auctionService.edit(auctionDTO);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<String> acceptAuction(@PathVariable Long id) throws  Exception {
        return auctionService.accept(id);
    }

    @GetMapping("/{id}")
    public AuctionDTO getAuction(@PathVariable Long id) throws Exception {
        return auctionService.get(id);
    }

    @CrossOrigin
    @GetMapping()
    public List<AuctionDTO> getAllAuction() throws Exception {
        return auctionService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuction(@PathVariable Long id) throws Exception {
        return auctionService.delete(id);
    }
}
