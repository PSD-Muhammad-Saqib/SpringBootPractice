package com.practice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.models.Employee;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee, Integer>{

}
