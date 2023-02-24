package com.primeiroprojeto.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeiroprojeto.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
