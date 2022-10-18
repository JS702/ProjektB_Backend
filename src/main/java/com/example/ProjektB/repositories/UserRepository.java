package com.example.ProjektB.repositories;

import com.example.ProjektB.domainobject.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    User findByUsername(String username);

    @Query("{ _id: { $in: ?0 } }")
    List<User> findByIds(Set<String> ids);

    @Query("{ $or:[ {deleted:false}, {deleted:true} ] }")
    Stream<User> findAllAsStream();

}
