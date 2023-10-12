package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.OrderDetail;

@Repository
public interface OrderDetailInterface extends JpaRepository<OrderDetail, Integer> {

}
