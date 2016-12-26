package com.jackbaretto.scrumtest.security;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service used for user authentication.
 * <p>
 * Created by mehdi on 22/12/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UserNotFoundException("User " + username + " was not found in the database");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //TODO Add granted authorities.
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);

    }
}
