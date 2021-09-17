package com.howtodoinjava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disable caching
        http.headers().cacheControl();
        http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .invalidSessionUrl("/login.html");
        
        http.cors().and().formLogin()
        .loginPage("/login.html").loginProcessingUrl("/login").permitAll().failureUrl("/login-error").successHandler(authenticationSuccessHandler).and().csrf().disable() // disable csrf for our requests.
        .authorizeRequests()
        .antMatchers("/genzest-d.html").hasAuthority("ROLE_ADMIN")
        .antMatchers("/recruiter-d.html").hasAuthority("ROLE_RECRUITER")
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/user/registration").permitAll()
        .antMatchers(HttpMethod.POST,"/user/admin/registration").permitAll()
        .antMatchers(HttpMethod.POST,"/login").permitAll()
        .antMatchers(HttpMethod.GET,"/registrationConfirm").permitAll()
        .antMatchers(HttpMethod.GET,"/api/image/logo").permitAll()
        .antMatchers(HttpMethod.GET,"/console").permitAll()
        .antMatchers(HttpMethod.GET,"/getLocations").permitAll()
        .antMatchers(HttpMethod.POST,"/getFilterJobs").permitAll()
        .antMatchers(HttpMethod.GET,"/getAllJobs").permitAll()
        .antMatchers(HttpMethod.POST,"/user/savePassword").permitAll()
        .antMatchers("/registrationConfirm.html").permitAll()
        .antMatchers("/loadStatesByCountry/**").permitAll()
        .antMatchers("/loadCitiesByState/**").permitAll()
        .antMatchers("/signup.html").permitAll()
        .antMatchers("/user/resetPassword").permitAll()
        .antMatchers("/badUser").permitAll()
        .antMatchers("/forgotpassword").permitAll()
        .antMatchers("/edit.html").permitAll()
        .antMatchers("/assets-2/**").permitAll()
        .antMatchers("/assets-1/**").permitAll()
        .antMatchers("/assets-3/**").permitAll()
        .antMatchers("/assets/**").permitAll()
        .antMatchers("/index.html").permitAll()
        .antMatchers("/editCategory.html").permitAll()
        .antMatchers("/user/changePassword").permitAll()
        
        
        
        
        .anyRequest().authenticated().and()
        .exceptionHandling().accessDeniedPage("/accessdenied");
//        .and().
//        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Add a filter to validate the tokens with every request
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // Create a default account
    	auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    
    

}
