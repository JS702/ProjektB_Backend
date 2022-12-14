package com.example.ProjektB.controller;

import com.example.ProjektB.config.JwtTokenProvider;
import com.example.ProjektB.mapper.UserMapper;
import com.example.ProjektB.pojo.AuthRequest;
import com.example.ProjektB.pojo.UserDto;
import com.example.ProjektB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/login" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    public UserDto login( @RequestBody AuthRequest authRequest ) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken( authRequest.getUsername(), authRequest.getPassword() ) );

        UserDto user = this.userMapper.mapToDto( this.userService.getUserByUsername( authRequest.username ) );
        user.setJwtToken( jwtTokenProvider.generateToken( authentication ) );
        return user;
    }

}
