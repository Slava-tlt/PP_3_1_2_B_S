package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kata.spring.boot_security.demo.DAO.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAOImp;


    @Autowired
    public RoleServiceImpl(RoleDAO roleDAOImp) {
        this.roleDAOImp = roleDAOImp;
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDAOImp.getAllRoles();
    }
}
