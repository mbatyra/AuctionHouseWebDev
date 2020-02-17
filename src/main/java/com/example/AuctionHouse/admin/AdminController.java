package com.example.AuctionHouse.admin;

import com.example.AuctionHouse.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        return userService.delete(id);
    }

    @DeleteMapping("/{adminId/{userId}")
    public ResponseEntity<String> mockDeleteUser(@PathVariable Long adminId, @PathVariable Long userId) throws Exception {
        return userService.mockDelete(adminId, userId);
    }
}
