package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.DAO.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Override
    public Set<Role> getAllRoles(List<Long> roles) {

        return roleDAO.getAllRoles(roles);
    }

    @Override
    public void addRole(Set<Role> roles) {
        roleDAO.addRole(roles);
    }
}
