package com.jackbaretto.scrumtest.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by mehdi on 26/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceImplTest {
    public static final String USER = "user";
    public static final String PASSWORD = "Azerty12";

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @Test(expected = UserNotFoundException.class)
    public void loadUserByUsernameShouldThrowExceptionWhenUserIsntInDatabase() {
        Mockito.when(userRepository.findByName(Mockito.anyString())).thenReturn(null);
        userDetailsService.loadUserByUsername("userName");
    }

    @Test
    public void loadUserByUsernameShouldReturnUserDetails() {
        mockData();

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(USER);


        Assert.assertEquals(USER, userDetails.getUsername());
        Assert.assertEquals(PASSWORD, userDetails.getPassword());
        Assert.assertEquals(1, userDetails.getAuthorities().size());

    }

    private void mockData() {
        User user = new User();
        Mockito.when(userRepository.findByName(USER)).thenReturn(user);

        setPrivateField(user, "name", USER);
        setPrivateField(user, "password", PASSWORD);

        Mockito.when(userRepository.findByName(Mockito.anyString())).thenReturn(user);
    }


    /**
     * Set private field value.
     */
    private void setPrivateField(User user, String fieldName, String value) {
        Field nameField = ReflectionUtils.findField(User.class, fieldName);
        nameField.setAccessible(true);
        try {
            nameField.set(user, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        nameField.setAccessible(false);
    }
}