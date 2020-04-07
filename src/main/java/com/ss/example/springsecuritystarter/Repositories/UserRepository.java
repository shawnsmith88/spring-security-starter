package com.ss.example.springsecuritystarter.Repositories;

import com.ss.example.springsecuritystarter.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public User findByUsername(@Param("username") String username);
}
