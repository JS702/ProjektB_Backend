package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainvalue.GameMode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface GameRepository extends MongoRepository<Game, String> {

    Stream<Game> findAllByUserId( String userId );

    @Query( value = "{gameMode:  {$eq: ?0}}", sort = "{'score.score': 1}" )
    Stream<Game> findAllByGameMode( GameMode gameMode );

    @Query( "{ _id: { $in: ?0 } }" )
    List<Game> findByIds( Set<String> ids );

    @Query( value = "{$and: [{userId:  {$eq: ?0}}, {gameMode:  {$eq: ?1}}]}", sort = "{'score.score': 1}" )
    Stream<Game> findAllByUserIdAndGameMode( String userId, GameMode gameMode );

}
