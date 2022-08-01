package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleDAO {

    Set<Role> getAllRoles(List<Long> roles);

    void addRole(Set<Role> roles);
}
