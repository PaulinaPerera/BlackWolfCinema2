package com.uady.blackWolfCinema.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name="user")
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @Column(name="user_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="last_Name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

}
