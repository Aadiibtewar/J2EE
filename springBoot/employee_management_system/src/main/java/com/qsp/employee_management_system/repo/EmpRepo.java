package com.qsp.employee_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.employee_management_system.dto.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

    Employee findByEmail(String email);

    Employee findByPhone(long phone);

    List<Employee> findByName(String name);

    List<Employee> findByAddress(String address);

    List<Employee> findBySalaryLessThan(double salary);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

	List<Employee> findByDesignation(String designation);

	

}
