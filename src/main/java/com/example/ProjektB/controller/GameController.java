package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.Position;
import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.service.GameService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/game" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameController {

    private final GameService gameService;

    public List<Position> positions = new ArrayList<Position>();
    public List<String> picturePaths = new ArrayList<String>();

    @GetMapping
    public GameDto getGameDto(/*int rounds*/) {

        int rounds = 5;

        for (int i = 0; i <= 5; i++) {
            picturePaths.add("src\\main\\resources\\images\\" + i + ".png");
        }

        //nur für Test
        positions.add(new Position(0, 0));
        positions.add(new Position(1, 1));
        positions.add(new Position(2, 2));
        positions.add(new Position(3, 3));
        positions.add(new Position(4, 4));
        positions.add(new Position(5, 5));

        GameDto gameDto = new GameDto();
        
        for (int j = 0; j <= rounds; j++) {
            RoundData roundData = new RoundData();

            int randomInt = ThreadLocalRandom.current().nextInt(0, picturePaths.size());

            roundData.setPicturePath(picturePaths.remove(randomInt));
            roundData.setPosition(positions.remove(randomInt));

            gameDto.addRoundDataToList(roundData);
        }

        return gameDto;
    }
}