package com.UserLogin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.UserLogin.jwt.JwtFilter;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class UserSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    UserLogService userlogservice;
    
    @Autowired
    JwtFilter jwtfilter;
    
    @Bean
    public AuthenticationProvider authprovider() {
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setUserDetailsService(userlogservice);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
                
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub,"/update/{did}"
        http.csrf().disable().authorizeRequests().
        antMatchers("/authenticate","/get/{token}").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest()
        .authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
//        http.sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//        .invalidSessionUrl("/login");
//        http.sessionManagement()
//        .maximumSessions(1)
//        .expiredUrl("/login?invalid-session=true");
        
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }
    
    

    
}
