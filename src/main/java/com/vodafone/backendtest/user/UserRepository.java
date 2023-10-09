package com.vodafone.backendtest.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/** This is a Spring Data Repository, what allows access to data from the database.
 * This interface extends MongoRepository, so we can use MongoRepository’s methods (save(), findOne(), findAll(), ...)
 * without implementing these methods. */
public interface UserRepository extends MongoRepository<User, Integer> {
    /** We have also implemented a custom method called "findById", which accepts a id of type String (our id type)
     * and returns the User which id contains input id. */
    Optional<User> findById(String id);
}
