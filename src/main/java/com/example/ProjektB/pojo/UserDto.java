package com.example.ProjektB.pojo;

import com.example.ProjektB.domainvalue.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDto {

    private String id;

    private String email;

    @JsonIgnore
    private String password;

    private String username;

    private UserType type;

    private String jwtToken;
}
