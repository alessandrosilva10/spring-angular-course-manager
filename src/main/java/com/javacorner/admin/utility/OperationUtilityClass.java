package com.javacorner.admin.utility;

import javax.persistence.EntityNotFoundException;

import com.javacorner.admin.dao.UserDAO;
import com.javacorner.admin.entity.User;

public class OperationUtilityClass {
    public static void usersOperations(UserDAO userDAO) {
        //createUsers(userDAO);
        //updateUser(userDAO);
        //deleteUser(userDAO);
        fetchUsers(userDAO);
    }

    private static void fetchUsers(UserDAO userDAO) {
        userDAO.findAll().forEach(user -> System.out.println(user.toString()));
    }

    private static void deleteUser(UserDAO userDAO) {
        User user = userDAO.findById(1L).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userDAO.delete(user);
    }

    private static void updateUser(UserDAO userDAO) {
        User user = userDAO.findById(1L).orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setEmail("newEmail@gmail.com");
        userDAO.save(user);
    }

    private static void createUsers(UserDAO userDAO) {
        User user1 = new User("user1@gmail.com", "12345678");
        userDAO.save(user1);
    }
}
