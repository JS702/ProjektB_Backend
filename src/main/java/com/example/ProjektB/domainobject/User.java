package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String id;

    private boolean deleted;

    private String email;

    @JsonIgnore
    private String password;

    private String username;

    private UserType type;

    private String description;

}
