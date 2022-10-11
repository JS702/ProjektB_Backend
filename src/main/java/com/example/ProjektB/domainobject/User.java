package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.UserType;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class User extends DefaultObject {

    @Indexed
    private String email;

    private String password;

    private String salt;

    private String username;

    private LocalDate birthday;

    private UserType type;

    private ZonedDateTime lastLogin;

}
