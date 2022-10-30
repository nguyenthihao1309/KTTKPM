package com.example.springbootjwtpermissionrole.service;

import com.example.springbootjwtpermissionrole.model.Role;

public interface RoleService {
    Role findByName(String name);
}
