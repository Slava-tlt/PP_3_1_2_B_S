package ru.kata.spring.boot_security.demo.DAO;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {

        return em.unwrap(Session.class).createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(Long id, User user) {

        getById(id).setName(user.getName());
        getById(id).setSurname(user.getSurname());
        getById(id).setAge(user.getAge());
    }

    @Override
    public void delete(Long id) {
        em.remove(getById(id));
    }

    @Override
    public User getUserName(String name) {
        return (User) em.createQuery("select u from User u where u.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
