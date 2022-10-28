package com.example.ProjektB.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjektB.domainobject.Position;
import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.repositories.RoundRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameService {

    private final RoundRepository roundRepository;

    public GameDto createRoundDataTest(int rounds) {
        /*
         * List<Position> positions = new ArrayList<Position>();
         * List<String> picturePaths = new ArrayList<String>();
         * 
         * for (int i = 0; i <= 5; i++) {
         * picturePaths.add("src\\main\\resources\\images\\" + i + ".png");
         * }
         * 
         * // nur für Test
         * positions.add(new Position(0, 0));
         * positions.add(new Position(1, 1));
         * positions.add(new Position(2, 2));
         * positions.add(new Position(3, 3));
         * positions.add(new Position(4, 4));
         * positions.add(new Position(5, 5));
         * 
         * GameDto gameDto = new GameDto();
         * 
         * for (int j = 0; j <= rounds; j++) {
         * RoundData roundData = new RoundData();
         * 
         * int randomInt = ThreadLocalRandom.current().nextInt(0,
         * picturePaths.size());
         * 
         * roundData.setPicturePath(picturePaths.remove(randomInt));
         * roundData.setPosition(positions.remove(randomInt));
         * 
         * gameDto.addRoundDataToList(roundData);
         * }
         * return gameDto;
         */

        List<RoundData> roundDataList = new ArrayList<RoundData>();
        roundDataList = roundRepository.getAll();

        GameDto gameDto = new GameDto();

        for (int i = 0; i <= rounds; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, roundDataList.size());
            
            gameDto.addRoundDataToList(roundDataList.remove(randomInt));
        }

        return gameDto;

        //return null;
    }

    public RoundData save(RoundData roundData) {
        return this.roundRepository.save(roundData);
    }
}