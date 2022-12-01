package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;

public interface MediaFileRepository extends MongoRepository<MediaFile, String> {

    @Query( "{ id: { $in: ?0 } }" )
    List<MediaFile> findByIds( Set<String> ids );

}
