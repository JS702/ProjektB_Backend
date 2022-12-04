package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.service.GameService;
import com.example.ProjektB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping( value = "/game" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameController {


    private final GameService gameService;

    private final UserService userService;

    @GetMapping
    public GameDto getGame( @RequestParam int rounds ) {
        return this.gameService.getGameDto( rounds );
    }

    @PostMapping
    public Game saveGame( @RequestBody Game game ) {
        this.userService.setScore( game.getUserId(), game.getScore() );
        return this.gameService.save( game );
    }

}