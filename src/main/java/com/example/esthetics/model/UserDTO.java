package com.example.esthetics.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;


@Table(name = "user")
@Entity
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomer")
    private Long idCustomer;
    @Column(name = "name")
    private String name;
    @JsonProperty("surName")
    @Column(name = "surname")
    private String surName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public UserDTO(Long id, String name, String surName, String email, String password) {
        this.idCustomer = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {

    }

    public void setId(Long id) {
        this.idCustomer = id;
    }

    public Long getId() {
        return idCustomer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
