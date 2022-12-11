package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.pojo.ProfileData;
import com.example.ProjektB.pojo.ProfileDto;
import com.example.ProjektB.pojo.RegistrationData;
import com.example.ProjektB.service.GameService;
import com.example.ProjektB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/user" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class UserController {

    private final UserService userService;

    private final GameService gameService;

    @GetMapping( "/{userId}" )
    public User getUser( @PathVariable String userId ) {
        return this.userService.getUser( userId );
    }

    @GetMapping
    public User getUserByName( @RequestParam String userName ) {
        return this.userService.getUserByUsername( userName );
    }

    @GetMapping( "/profile/{userId}" )
    public ProfileDto getProfile( @PathVariable String userId ) {
        return this.gameService.getProfile( userId );
    }


    @PutMapping( "/create" )
    public User create( @RequestBody RegistrationData userData ) {
        return this.userService.createUser( userData, UserType.USER );
    }

    @PostMapping( "/update/{userId}" )
    public User update( @PathVariable String userId, @RequestBody ProfileData userData ) {
        return this.userService.update( userId, userData );
    }

}