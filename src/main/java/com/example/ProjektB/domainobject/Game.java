package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.RoundType;
import lombok.Data;

import java.util.List;

@Data
public class Game {

    private RoundType gameType;

    private int rounds;

    private List<String> picturePaths;

    private int score;

}
