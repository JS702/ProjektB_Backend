package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.service.DefaultUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final DefaultUserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return this.userService.getUser(userId);
    }

    @PutMapping("/create")
    public User create(@RequestBody User user) {
        System.out.println("User:" + user.toString());
        return this.userService.createUser(user, UserType.USER);
    }

}