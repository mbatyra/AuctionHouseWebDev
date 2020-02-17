package com.example.AuctionHouse.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException exception
    ) throws IOException, ServletException {

        String customResponse = new ObjectMapper()
                .writeValueAsString(new ResponseEntity<>("UNAUTHORIZED", HttpStatus.NOT_ACCEPTABLE));
        response.addHeader("Content-type", "application/json; charset=UTF-8");
        response.getWriter().append(customResponse);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
