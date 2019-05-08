package com.capgemini.onetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onetomany.employee.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
