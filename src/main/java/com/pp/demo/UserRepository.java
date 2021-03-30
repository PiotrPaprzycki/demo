package com.pp.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    User user = new User("Piotr", "Paprzycki", 22);
    User user1 = new User("Lukasz", "Kowalski", 21);
    User user2 = new User("Ula", "Walaszek", 29);


    public UserRepository(List<User> userList) {
        this.userList = userList;
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

    public String printUserList() {
        String usersDetails = "";
        for (User user : userList) {
            usersDetails += (user.getName() + " " + user.getSurname() + " " + user.getAge() + "<br/>");
        }
        return usersDetails;
    }
}
