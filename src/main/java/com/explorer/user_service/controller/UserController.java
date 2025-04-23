package com.explorer.user_service.controller;

import com.explorer.user_service.exception.InvalidRoleException;
import com.explorer.user_service.exception.UserNotFoundException;
import com.explorer.user_service.model.Person;
import com.explorer.user_service.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createUser(@RequestBody Person person) {
        return new ResponseEntity<>(userService.createUser(person),HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updateUser(@PathVariable Long id, @RequestBody Person updatedPersonDetails) {
        return new ResponseEntity<>(userService.updateUser(id, updatedPersonDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable Long id) {
        Optional<Person> userbyId = userService.findUserByUserId(id);
        if(userbyId.isPresent()) {
            return new ResponseEntity<>(userbyId.get(), HttpStatus.OK);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @GetMapping("/roles/{role}")
    public ResponseEntity<List<Person>> getUserBasedOnRoleUsers(@PathVariable String role) {
        List<String> validRoles = Arrays.asList("admin","user");
        if(!validRoles.contains(role)) {
            throw new InvalidRoleException(role);

        }
        return new ResponseEntity<>(userService.findUserBasedOnRoles(role), HttpStatus.OK);
    }

}
