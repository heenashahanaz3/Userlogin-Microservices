package com.UserLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UserLogin.jwt.JwtUtils;
import com.UserLogin.model.UserLogin;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping()
public class UserLoginController {
    

    //private EmployeeService employeeService;
    
    @Autowired
    AuthenticationManager authmanage;
    
    @Autowired
    JwtUtils jwtUtils;
    
     @GetMapping("/get/{token}")
     public String extractUsernamesbytoken(@PathVariable String token) {
    	 return jwtUtils.extractUsername(token);
     }
    
    //login
    @PostMapping("/authenticate")
    public String authUser(@RequestBody UserLogin userlogin){
        try {
            @SuppressWarnings("unused")
            
            Authentication authtoken=  authmanage.authenticate(
                    new UsernamePasswordAuthenticationToken(userlogin.getEmail(), userlogin.getPassword()));
            String token = jwtUtils.generateToken(userlogin.getEmail().toString());
            return token;
            
        } catch (Exception e) {
            // TODO: handle exception
            return "Login Failed!!";
        }
    }

}