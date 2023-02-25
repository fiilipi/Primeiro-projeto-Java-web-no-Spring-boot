package com.primeiroprojeto.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeiroprojeto.userdept.entities.User;

import jakarta.transaction.Transactional;
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
