package com.example.kontemple.controller;

import com.example.kontemple.model.User;
import com.example.kontemple.repository.UserRepository;
import com.example.kontemple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class MainController {

    @Autowired // to get the called userRepository
    private UserRepository userRepository;

    @Autowired
    UserService userService;
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }


    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id){
        Optional<User> user=userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
    @DeleteMapping("/user/delete")
    public void deleteUser(){
        userService.deleteAll();
    }

    @PutMapping("/user/{id}")
    Optional<User> updateUser(@RequestBody User user,@PathVariable Long id){
        return Optional.of(userRepository.findById(id)
                .map(newUser -> {
                    newUser.setName(user.getName());
                    newUser.setEmail(user.getEmail());
                    return userRepository.save(newUser);

                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                }));
    }
}
