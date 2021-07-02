package com.howtodoinjava.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.howtodoinjava.model.Role;
import com.howtodoinjava.model.User;

public class MyUserDetails implements UserDetails {
	  private User user;
	     
	    public MyUserDetails(User user) {
	        this.user = user;
	    }
	    
	    public String getFirstName()
	    {
	    	return this.user.getFirstName();
	    }
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        Set<Role> roles = (Set<Role>) user.getRoles();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	         
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        return authorities;
	    }
	 
	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return user.getEmail();
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return user.isEnabled();
	    }
	}
