package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaFileRepository extends MongoRepository<MediaFile, String> {

}
