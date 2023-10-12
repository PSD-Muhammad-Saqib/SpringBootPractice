package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
