package com.pp.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("Piotr", "Paprzycki", 22));
        userList.add(new User("Lukasz", "Kowalski", 21));
        userList.add(new User("Ula", "Walaszek", 29));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

}
