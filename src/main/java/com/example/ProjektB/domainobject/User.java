package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.GameMode;
import com.example.ProjektB.domainvalue.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Optional;

@Data
@Document( collection = "user" )
@JsonInclude( JsonInclude.Include.NON_NULL )
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

    private String profilePictureId;

    private List<Score> scores;

    public Optional<Score> getScoreByGameMode( GameMode gameMode ) {
        return this.scores.stream().filter( gameMode::equals ).findFirst();
    }

}
