package com.tosloth.toslothserver.user;

import exceptionController.user.UserAlreadyExistsException;
import exceptionController.user.UserNotFoundException;
import exceptionController.user.UserWrongLoginDetailsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/users")
    User registerUser(@RequestBody User newUser) {
        if (!repository.findUserByNickname(newUser.getNickname()).isEmpty())
            throw new UserAlreadyExistsException(newUser.getNickname());

        return repository.save(newUser);
    }

    @PostMapping("/users/login")
    User loginUser(@RequestBody User logUser) {
        User user = null;
        if (!repository.findUserByNickname(logUser.getNickname()).isEmpty()) {
            user = repository.getUserByNickname(logUser.getNickname());

            if(user.getPassword().equals(logUser.getPassword())){
                user = repository.getUserByNickname(logUser.getNickname());
                return user;
            }
            throw new UserWrongLoginDetailsException(logUser.getNickname(),logUser.getPassword());
        }
        throw new UserWrongLoginDetailsException(logUser.getNickname(),logUser.getPassword());
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
