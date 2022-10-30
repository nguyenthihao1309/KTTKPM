package com.example.onthigk.repository;

import com.example.onthigk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserName(String userName);

}
