package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.Position;
import com.example.ProjektB.domainobject.Round;
import com.example.ProjektB.domainvalue.RoundType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface RoundRepository extends MongoRepository<Round, String> {

    @Query( "{ _id: { $in: ?0 } }" )
    List<Round> findByIds( Set<String> ids );

    Round findByPosition( Position position );

    List<Round> findByType( RoundType type );

}
