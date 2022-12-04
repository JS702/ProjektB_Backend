package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.GameMode;
import lombok.Data;

@Data
public class Score {

    private GameMode gameMode;

    private Integer score;

    private Float averageDistance;

    private Float averageTime;

}
