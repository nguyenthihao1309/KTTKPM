package com.example.springbootjwtpermissionrole.dao;

import com.example.springbootjwtpermissionrole.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}
