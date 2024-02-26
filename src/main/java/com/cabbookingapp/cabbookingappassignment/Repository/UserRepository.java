package com.cabbookingapp.cabbookingappassignment.Repository;

import com.cabbookingapp.cabbookingappassignment.Models.User;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getName(), user);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
