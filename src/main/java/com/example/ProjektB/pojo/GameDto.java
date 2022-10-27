package com.example.ProjektB.pojo;

import java.util.ArrayList;
import java.util.List;

import com.example.ProjektB.domainobject.RoundData;

public class GameDto {

    private List<RoundData> rounds = new ArrayList<RoundData>();

    public void addRoundDataToList(RoundData roundData) {
        rounds.add(roundData);
    }

    public List<RoundData> getRoundDataList() {
        return rounds;
    }

}
