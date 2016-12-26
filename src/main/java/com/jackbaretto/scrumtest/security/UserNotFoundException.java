package com.jackbaretto.scrumtest.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 Thrown if an {@link UserDetailsService} implementation cannot locate a {@link User} by
 * its username.
 * Created by mehdi on 26/12/16.
 */
public class UserNotFoundException extends AuthenticationException {


    public UserNotFoundException(String msg) {
        super(msg);
    }
}
