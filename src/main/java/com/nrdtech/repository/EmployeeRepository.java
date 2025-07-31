package com.nrdtech.repository;

import com.nrdtech.entity.EmployeeEntity;
import com.nrdtech.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
