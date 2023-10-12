package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Order;

@Repository
public interface OrderInterface extends JpaRepository<Order, Integer>{

}
