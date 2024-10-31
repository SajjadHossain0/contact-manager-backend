package com.contact_manager.Controllers;

import com.contact_manager.Entities.User;
import com.contact_manager.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/contact-manager")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    public Boolean loginUser(@RequestBody User user) {
        return null;
    }
}
