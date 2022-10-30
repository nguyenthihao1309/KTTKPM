package com.example.springbootjwtpermissionrole.service;

import com.example.springbootjwtpermissionrole.dao.RoleDao;
import com.example.springbootjwtpermissionrole.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
