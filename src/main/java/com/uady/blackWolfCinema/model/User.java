package com.uady.blackWolfCinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name="user")
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    @Id
    @Column(name="userName")
    private String userName;
    @Column(name="name")
    private String name;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;

}
