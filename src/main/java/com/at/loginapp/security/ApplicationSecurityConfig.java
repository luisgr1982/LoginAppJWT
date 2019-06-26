package com.at.loginapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.at.loginapp.utils.Constants.REGISTER_URL;
import static com.at.loginapp.utils.Constants.LOGIN_URL;
import static com.at.loginapp.utils.Constants.H2DATABASE_URL;
import static com.at.loginapp.utils.Constants.HOME_URL;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserH2DetailsService userDetailsService;
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(H2DATABASE_URL).permitAll()
        .antMatchers(HttpMethod.POST,REGISTER_URL,LOGIN_URL).permitAll()
        .antMatchers(HOME_URL).hasAuthority("ROLE_USER")
        .anyRequest().authenticated()
        .and().httpBasic()
       // .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login")
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().headers().frameOptions().disable()
        .and().csrf().disable()
        .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
