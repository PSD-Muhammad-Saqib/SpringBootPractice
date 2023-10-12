package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Shipper;

@Repository
public interface ShipperInterface extends JpaRepository<Shipper, Integer>{

}
