package com.example.ProjektB.pojo;

import com.example.ProjektB.domainobject.Score;
import com.example.ProjektB.domainvalue.GameMode;
import lombok.Data;

import java.util.List;

@Data
public class GameDto {

    private String id;

    private GameMode gameMode;

    private List<String> roundIds;

    private Score score;

    private String userId;

}
