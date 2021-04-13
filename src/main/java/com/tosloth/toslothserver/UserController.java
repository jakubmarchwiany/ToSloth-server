package com.tosloth.toslothserver;

import java.util.List;

import exceptionController.UserAlreadyExistsException;
import exceptionController.UserNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/users")
    User registerUser(@RequestBody User newUser) {
        if (!repository.findUserByNickname(newUser.getNickname()).isEmpty())
            throw new UserAlreadyExistsException(newUser.getNickname());

        return repository.save(newUser);
    }

    @PostMapping("/XDXD")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
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
            user = null;
        }
        return user;
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newEmployee, @PathVariable String id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setNickname(newEmployee.getNickname());
                    employee.setLastname(newEmployee.getLastname());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
