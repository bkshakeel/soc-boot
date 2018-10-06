package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    void save(Employee employee);
}
