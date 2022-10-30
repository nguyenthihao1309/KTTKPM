package com.example.springbootjwtpermissionrole.dao;

import com.example.springbootjwtpermissionrole.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
