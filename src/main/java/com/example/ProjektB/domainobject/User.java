package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends DefaultObject {

    private String email;

    @JsonIgnore
    private String password;

    private String username;

    private UserType type;

}
