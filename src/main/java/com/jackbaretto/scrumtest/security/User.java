package com.jackbaretto.scrumtest.security;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User representation for authentication.
 * Created by mehdi on 22/12/16.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column()
    private String name;
    @Column
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
