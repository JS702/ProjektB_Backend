package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainvalue.GameMode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface GameRepository extends MongoRepository<Game, String> {

    Stream<Game> findAllByUserId( String userId );

    Stream<Game> findAllByGameMode( GameMode gameMode );

}
