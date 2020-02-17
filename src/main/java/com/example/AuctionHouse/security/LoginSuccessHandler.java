package com.example.AuctionHouse.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication
    ) throws IOException, ServletException {

        String customResponse = new ObjectMapper()
                .writeValueAsString(new ResponseEntity<>("SUCCESS", HttpStatus.ACCEPTED));
        response.addHeader("Content-type", "application/json; charset=UTF-8");
        response.getWriter().append(customResponse);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
