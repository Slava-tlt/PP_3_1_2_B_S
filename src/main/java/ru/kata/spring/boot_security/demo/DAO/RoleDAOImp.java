package ru.kata.spring.boot_security.demo.DAO;


import ru.kata.spring.boot_security.demo.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDAOImp implements RoleDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Set<Role> getAllRoles() {
        List<Role> list = em
                .createQuery("from Role role", Role.class)
                .getResultList();
        return new HashSet<>(list);
    }
}
