package com.example.AuctionHouse.login;

import com.example.AuctionHouse.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/authenticate")
    public String authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean authenticate = request.authenticate(response);
        return authenticate ? "index" : null;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @ModelAttribute UserDTO userDTO,
                        BindingResult result) throws Exception {

        return loginService.login(request, response, userDTO, result);

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute UserDTO userDTO) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }
}
