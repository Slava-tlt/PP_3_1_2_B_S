package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.DAO.UserDAO;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        userDAO.update(id, user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    public User getUserName(String name) {

        return userDAO.getUserName(name);
    }
}
