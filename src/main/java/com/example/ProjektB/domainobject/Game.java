package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.RoundType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document( collection = "games" )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Game {

    private RoundType roundType;

    private List<String> picturesIds;

    private Score score;

    private String userId;

}
