package com.tosloth.toslothserver.goal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface GoalRepository extends MongoRepository<Goal, String> {

    @Query("{ 'id' : ?0 }")
    Goal findGoalById(String id);

    @Query("{ 'owner' : ?0 }")
    List<Goal> findGoalByNickname(String nickname);
}