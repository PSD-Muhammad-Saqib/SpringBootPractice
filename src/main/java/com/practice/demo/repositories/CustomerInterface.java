package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Customer;

@Repository
public interface CustomerInterface extends JpaRepository<Customer, Integer>{

}
