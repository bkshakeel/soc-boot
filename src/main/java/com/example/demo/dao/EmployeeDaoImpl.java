package com.example.demo.dao;

import com.example.demo.mappers.EmployeeMyBatisMapper;
import com.example.demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeMyBatisMapper employeeMyBatisMapper;

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList=null;
        try {
            employeeList=employeeMyBatisMapper.findAllEmployees();
        }
        catch (Exception e) {
            throw new RuntimeException("");
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        try {
            employeeMyBatisMapper.saveEmployee(employee);
        }
        catch (Exception e) {
            throw new RuntimeException("unable to save");
        }
    }

    public void setEmployeeMyBatisMapper(EmployeeMyBatisMapper employeeMyBatisMapper) {
        this.employeeMyBatisMapper = employeeMyBatisMapper;
    }
}
