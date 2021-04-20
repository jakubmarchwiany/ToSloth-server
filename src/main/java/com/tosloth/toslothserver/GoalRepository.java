package com.tosloth.toslothserver;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface GoalRepository extends MongoRepository<Goal, String> {

    @Query("{ 'owner' : ?0 }")
    List<Goal> findGoalByNickname(String nickname);
}