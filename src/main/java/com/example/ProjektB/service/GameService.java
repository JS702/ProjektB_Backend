package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameService {

    private final GameRepository gameRepository;

    private final RoundService roundService;


    public Game createGame( int roundCount ) {
        //Todo get GameMode from frontend
        List<String> rounds = this.roundService.getRoundIds( roundCount );
        Game game = new Game();
        game.setRoundIds( rounds );
        return game;
    }

    public Game save( Game game ) {
        return this.gameRepository.save( game );
    }

}