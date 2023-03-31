package com.UserLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserLogin.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

}
