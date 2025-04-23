package com.explorer.user_service.service;

import com.explorer.user_service.exception.UserNotFoundException;
import com.explorer.user_service.model.Person;
import com.explorer.user_service.repository.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<Person> getAllUsers() {
        return userRepo.findAll();
    }

    public Person createUser(Person user) {
        return userRepo.save(user);
    }

    public Person updateUser(Long userId, Person updateUserDetails) {
        Person user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        user.setEmail(updateUserDetails.getEmail());
        user.setName(updateUserDetails.getName());
        user.setRole(updateUserDetails.getRole());
        return userRepo.save(user);
    }
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public Optional<Person> findUserByUserId(Long userId) {
        /* Optional<Person> user = userRepo.findById(userId);
        if(user.isPresent())
            return user.get();
        else {
            System.out.println("User not found for the userId " + userId);
            return null;
        }*/
        return userRepo.findById(userId);
    }

    public List<Person> findUserBasedOnRoles(String role) {
         return userRepo.findByRole(role);
    }
}
