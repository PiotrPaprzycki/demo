package com.pp.demo;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @GetMapping("/users")
    public String usersList() {

        return printUserList();
    }


    @RequestMapping("/add")
    public String addUser(@RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "surname", required = false) String surname,
                          @RequestParam Integer age) {
        User user = new User(name, surname, age);
        if (name == null || surname == null) {
            return "redirect:/err.html";
        } else {
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    public String printUserList() {
        StringBuilder usersDetails = new StringBuilder();
        for (User user : userRepository.getAll()) {
            usersDetails.append(user.getName() + " " + user.getSurname() + " " + user.getAge() + "<br/>");
        }
        return usersDetails.toString();
    }
}
