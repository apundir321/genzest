package com.howtodoinjava;

import java.io.IOException;
import java.security.Principal;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.howtodoinjava.dao.UserRepository;


@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	 @Autowired 
	 HttpSession session;
	 
	 @Autowired
	 UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String userName = "";
        if(authentication.getPrincipal() instanceof Principal) {
             userName = ((Principal)authentication.getPrincipal()).getName();

        }else {
            userName = ((User)authentication.getPrincipal()).getUsername();
        }
        
        //HttpSession session = request.getSession();
        com.howtodoinjava.model.User user = userRepository.findByEmail(authentication.getName());
        session.setAttribute("user", user);
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/genzest-d.html");
        } else {
            httpServletResponse.sendRedirect("/student-d.html");
        }
    }
}