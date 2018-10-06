package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
