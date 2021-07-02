package com.howtodoinjava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	

	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disable caching
        http.headers().cacheControl();

        http.cors().and().formLogin()
        .loginPage("/login.html").loginProcessingUrl("/login").permitAll().successHandler(authenticationSuccessHandler).and().csrf().disable() // disable csrf for our requests.
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/user/registration").permitAll()
        .antMatchers(HttpMethod.POST,"/login").permitAll()
        .antMatchers(HttpMethod.GET,"/registrationConfirm").permitAll()
        .antMatchers(HttpMethod.GET,"/api/image/logo").permitAll()
        .antMatchers(HttpMethod.GET,"/console").permitAll()
        .antMatchers(HttpMethod.GET,"/getLocations").permitAll()
        .antMatchers(HttpMethod.POST,"/getFilterJobs").permitAll()
        .antMatchers(HttpMethod.GET,"/getAllJobs").permitAll()
        .antMatchers("/registrationAccountConfirm").permitAll()
        .antMatchers("/badUser").permitAll()
        .antMatchers("/edit.html").permitAll()
        .antMatchers("/assets-2/**").permitAll()
        .antMatchers("/assets-1/**").permitAll()
        .antMatchers("/assets-3/**").permitAll()
        .antMatchers("/assets/**").permitAll()
        .antMatchers("/index.html").permitAll()
//        .antMatchers("/profile.html").permitAll()
//        .antMatchers("/earning.html").permitAll()
//        .antMatchers("/edit.html").permitAll()
//        .antMatchers("/searchjobs.html").permitAll()
//        .antMatchers("/appliedjobs.html").permitAll()
//        .antMatchers("/category-genz.html").permitAll()
//        .antMatchers("/category-edit-genz.html").permitAll()
//        .antMatchers("/jobtype-genz.html").permitAll()
//        .antMatchers("/jobtype-edit-genz.html").permitAll()
//        .antMatchers("/course-genz.html").permitAll()
//        .antMatchers("/course-edit-genz.html").permitAll()
//        .antMatchers("/timeslot-genz.html").permitAll()
//        .antMatchers("/timeslot-edit-genz.html").permitAll()
//        .antMatchers("/emp-edit-genz.html").permitAll()
//        .antMatchers("/employer-genz.html").permitAll()
//        .antMatchers("/editjobs-genz.html").permitAll()
//        .antMatchers("/updateProfile.html").permitAll()
//        .antMatchers("/searchJobs.html").permitAll()
//        .antMatchers("/jobs-genz.html").permitAll()
//        .antMatchers("/updatejobs-genz.html").permitAll()
//        .antMatchers("/searchCandidates.html").permitAll()
//        .antMatchers("/searchcandi-genz.html").permitAll()
//        .antMatchers("/genzest-d.html").permitAll()
//        .antMatchers("/showCandidateProfile").permitAll()
//        .antMatchers("/searchjobs-genz.html").permitAll()
//        .antMatchers("/recruiter-d.html").permitAll()
//        .antMatchers("/jobs.html").permitAll()
//        .antMatchers("/editjobs-recruiter.html").permitAll()
//        .antMatchers("/updatejobs-recruiter.html").permitAll()
//        .antMatchers("/emloyer.html").permitAll()
//        .antMatchers("/updatejobs-recruiter.html").permitAll()
//        .antMatchers("/applyJob").permitAll()
//        .antMatchers("/updatePreferences.html").permitAll()
        
        
        
        
        
        .anyRequest().authenticated();
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
