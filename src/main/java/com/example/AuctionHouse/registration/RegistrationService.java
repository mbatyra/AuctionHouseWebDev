package com.example.AuctionHouse.registration;

import com.example.AuctionHouse.user.User;
import com.example.AuctionHouse.user.UserDTO;
import com.example.AuctionHouse.user.UserRepository;
import com.example.AuctionHouse.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity<String> register(UserDTO userDTO) throws Exception {

        User user = userService.addUser(userDTO);

        return new ResponseEntity<>("Account created, check your email address.", HttpStatus.OK);


    }

}
