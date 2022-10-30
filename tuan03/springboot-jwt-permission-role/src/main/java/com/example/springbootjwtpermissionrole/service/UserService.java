package com.example.springbootjwtpermissionrole.service;

import com.example.springbootjwtpermissionrole.model.User;
import com.example.springbootjwtpermissionrole.model.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
