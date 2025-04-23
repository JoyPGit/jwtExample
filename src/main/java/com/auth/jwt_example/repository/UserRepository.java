package com.auth.jwt_example.repository;

import com.auth.jwt_example.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { //
    Optional<User> findByEmail(String email);
}
