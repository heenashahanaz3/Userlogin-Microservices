package com.UserLogin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.UserLogin.model.UserLogin;



@SuppressWarnings("serial")
public class UserLog implements UserDetails{
    UserLogin userlogin = new UserLogin();
    
    public UserLog(UserLogin userlogin){
        this.userlogin=userlogin;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singleton(new SimpleGrantedAuthority("RETAIL"));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userlogin.getPassword();
    }

    

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userlogin.getEmail();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}