package com.fanverse.login_signup_service.repository;

import com.fanverse.login_signup_service.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
}
