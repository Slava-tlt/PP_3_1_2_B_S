package ru.kata.spring.boot_security.demo.DAO;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImp implements RoleDAO{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Set<Role> getAllRoles(List<Long> roles) {

        TypedQuery<Role> query = em.createQuery("select r from Role r where r.id=:role", Role.class);
        query.setParameter("role", roles);

        return new HashSet<>(query.getResultList());
    }
}
