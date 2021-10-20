package com.howtodoinjava.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.howtodoinjava.dao.UserRepository;
import com.howtodoinjava.model.Role;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	HttpSession session;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if (user == null ) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}else
		{
			UserProfile profile = user.getUserProfile();
			if(profile!=null)
			{
				if(profile.getStatus()!=null && profile.getStatus().equals("DELETED"))
				{
					throw new UsernameNotFoundException("User not found with username: " + username);
				}
			}
		}
		if(!user.isEnabled())
		{
			session.setAttribute("errorLoginMessage", "Email is not verified!");
			throw new UsernameNotFoundException("User not verified");
		}
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("userObj", user);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Role authority: user.getRoles())
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
	}
	
}