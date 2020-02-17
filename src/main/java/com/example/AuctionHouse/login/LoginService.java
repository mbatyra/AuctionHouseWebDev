package com.example.AuctionHouse.login;

import com.example.AuctionHouse.user.UserDTO;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {

    private RequestCache requestCache = new HttpSessionRequestCache();


    public String login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO, BindingResult result) {
        String returnStatement = null;

        try {
            request.login(userDTO.getLogin(), userDTO.getPassword());
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null) {
                returnStatement = "redirect:" + savedRequest.getRedirectUrl();
                //return "redirect:" + savedRequest.getRedirectUrl();
            } else {
                returnStatement = "redirect:/";
                //return "redirect:/";
            }

        } catch (
                ServletException authenticationFailed) {
            result.rejectValue(null, "authentication.failed");
            returnStatement = "login";
            //return "login";
        }
        return returnStatement;

    }



}
