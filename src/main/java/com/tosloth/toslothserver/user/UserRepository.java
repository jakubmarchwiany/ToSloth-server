package com.tosloth.toslothserver.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'nickname' : ?0 }")
    User getUserByNickname(String nickname);


    @Query("{ 'nickname' : ?0 }")
    List<User> findUserByNickname(String nickname);
}
