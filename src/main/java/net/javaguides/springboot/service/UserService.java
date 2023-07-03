package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User updateUser(Long id, User user);

    User getUserById(Long userId);
    List<User> getAllUsers();
    void deleteUser(Long userId);
}
