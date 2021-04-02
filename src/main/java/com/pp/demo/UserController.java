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
        StringBuilder usersDetails = new StringBuilder();
        for (User user : userRepository.getAll()) {
            usersDetails.append(user.getName()).append(" ")
                    .append(user.getSurname()).append(" ").append(user.getAge())
                    .append("<br/>");
        }
        return usersDetails.toString();

    }


    @RequestMapping("/add")
    public String addUser(@RequestParam(required = false) String name,
                          @RequestParam(required = false) String surname,
                          @RequestParam Integer age) {
        if (name == null || name.equals("")) {
            return "redirect:/err.html";
        } else {
            User user = new User(name, surname, age);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }
}
