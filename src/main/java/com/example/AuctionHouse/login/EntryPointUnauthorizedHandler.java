package com.example.AuctionHouse.login;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntryPointUnauthorizedHandler extends LoginUrlAuthenticationEntryPoint {

    public EntryPointUnauthorizedHandler(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if ( httpServletRequest.getHeader("accept")!=null && httpServletRequest.getHeader("accept").contains("application/json") ) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
        }
        else {
            super.commence(httpServletRequest, httpServletResponse, e);
        }
    }

}
