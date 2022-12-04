package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.GameMode;
import com.example.ProjektB.pojo.Score;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document( collection = "games" )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Game {

    private String id;

    private GameMode gameMode;

    private List<String> roundIds;

    private Score score;

    private String userId;

}
