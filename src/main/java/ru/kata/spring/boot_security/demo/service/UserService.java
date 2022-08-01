package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getById(Long id);

    public void update(Long id, User user);

    public void delete(Long id);

    public User getUserName(String name);
}
