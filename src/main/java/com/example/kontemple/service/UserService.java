package com.example.kontemple.service;

import com.example.kontemple.model.User;
import com.example.kontemple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }


    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }



}
