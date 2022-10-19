package com.example.ProjektB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.ProjektB.domainobject.AuthRequest;
import com.example.ProjektB.security.JwtTokenProvider;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public String login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        return jwtTokenProvider.generateToken(authentication);
    }
}
