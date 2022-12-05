package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entytis.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    User getUserById(Integer id);
    void updateUser(User user);
    void deleteUserById(Integer id);
    List<User> getAllUsers();

    User getUserByUsername(String username);
}

