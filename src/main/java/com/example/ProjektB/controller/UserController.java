package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.RegistrationData;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/user" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class UserController {

    private final UserService userService;

    @GetMapping( "/{userId}" )
    public User getUser( @PathVariable String userId ) {
        return this.userService.getUser( userId );
    }


    @PutMapping( "/create" )
    public User create( @RequestBody RegistrationData userData ) {
        return this.userService.createUser( userData, UserType.USER );
    }

}