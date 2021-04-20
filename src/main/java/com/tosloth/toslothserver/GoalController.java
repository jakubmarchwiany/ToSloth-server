package com.tosloth.toslothserver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoalController {

    private final GoalRepository repository;

    GoalController(GoalRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/goals")
    Goal addGoal(@RequestBody Goal goal) {


        System.out.println(goal.toString());
        System.out.println("eloszka");

        return repository.save(goal);
    }


    @GetMapping("/goals/{nickname}")
    List<Goal> all(@PathVariable String nickname) {

        return repository.findGoalByNickname(nickname);
    }






}
