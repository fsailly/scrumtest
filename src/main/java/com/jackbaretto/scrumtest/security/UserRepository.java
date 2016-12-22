package com.jackbaretto.scrumtest.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository used for authentication.
 * Created by mehdi on 22/12/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     *  Find user by his name.
     * @param name
     * @return User
     */
    User findByName(String name);
}
