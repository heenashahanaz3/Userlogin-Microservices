package com.UserLogin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.UserLogin.model.UserLogin;
import com.UserLogin.repository.UserLoginRepository;



@Service
public class UserLogService implements UserDetailsService{
    @Autowired
    UserLoginRepository userloginRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserLogin userlogin = userloginRepository.findById(username).get();
        if(userlogin == null) {
            return null;
        }
        
        return new UserLog(userlogin);
    }
    
}
