package com.example.kontemple.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.kontemple.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
