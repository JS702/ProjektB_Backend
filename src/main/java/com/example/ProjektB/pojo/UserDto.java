package com.example.ProjektB.pojo;

import com.example.ProjektB.domainvalue.UserType;

import lombok.Data;

@Data
public class UserDto {

    private String id;

    private boolean deleted;

    private String email;

    private String username;

    private UserType type;

    private String jwtToken;
}
