package com.example.esthetics.repository;

import com.example.esthetics.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long> {
    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    UserDTO getByEmail(String email);

    @Query(value = "SELECT idcustomer FROM user WHERE name = :name AND surname = :surName", nativeQuery = true)
    Integer getByNameNSurname(String name, String surName);
}
