package com.pp.demo;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserControler {

    private UserRepository userRepository;

    public UserControler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @GetMapping("/users")
    public String usersList() {

        return userRepository.printUserList();
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam String imie, @RequestParam String nazwisko, @RequestParam Integer wiek) {
        User user = new User(imie, nazwisko, wiek);
        if (imie.isEmpty()) {
            return "err.html";
        } else {
            userRepository.add(user);
            return "success.html";
        }
    }
}
