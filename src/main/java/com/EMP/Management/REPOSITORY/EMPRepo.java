package com.EMP.Management.REPOSITORY;

import com.EMP.Management.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMPRepo extends JpaRepository<Employee, Long> {
}
