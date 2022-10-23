package com.example.ProjektB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.ProjektB.domainobject.AuthRequest;
import com.example.ProjektB.mapper.UserMapper;
import com.example.ProjektB.pojo.UserDto;
import com.example.ProjektB.security.JwtTokenProvider;
import com.example.ProjektB.service.DefaultUserService;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private DefaultUserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public UserDto login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        UserDto user = this.userMapper.mapToDto(this.userService.getUserByUsername(authRequest.username));
        user.setJwtToken(jwtTokenProvider.generateToken(authentication));
        return user;
    }
}
