package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.pojo.RoundDto;
import com.example.ProjektB.service.RoundDataService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/game")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {

    private final RoundDataService roundDataService;
    /*
    @GetMapping
    public List<RoundData> getGameDto(@RequestParam int rounds) {
        return this.roundDataService.createRoundDataTest(rounds);
    }
    */
    @GetMapping
    public List<RoundDto> getGameDto(@RequestParam int rounds) {
        return this.roundDataService.createRoundDataTest(rounds);
    }
}