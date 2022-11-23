package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.Position;
import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.domainvalue.RoundType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface RoundRepository extends MongoRepository<RoundData, String> {

    @Query( "{ _id: { $in: ?0 } }" )
    List<RoundData> findByIds( Set<String> ids );

    RoundData findByPosition( Position position );

    List<RoundData> findByType( RoundType type );

}
