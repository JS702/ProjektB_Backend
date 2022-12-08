package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainvalue.GameMode;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.pojo.LeaderboardEntry;
import com.example.ProjektB.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( value = "/game" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameController {


    private final GameService gameService;

    @GetMapping
    public GameDto getGame( @RequestParam int rounds ) {
        return this.gameService.getGameDto( rounds );
    }

    @GetMapping
    public List<LeaderboardEntry> getScoreLeaderboard( @RequestParam GameMode gameMode ) {
        return this.gameService.getScoreLeaderboard( gameMode );
    }


    @PostMapping
    public Game saveGame( @RequestBody Game game ) {
        return this.gameService.save( game );
    }

}