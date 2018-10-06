package com.example.demo.dao;

import com.example.demo.mappers.EmployeeMyBatisMapper;
import com.example.demo.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeDaoImplTest {

    private EmployeeMyBatisMapper employeeMyBatisMapper;
    private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    private Employee employee =  new Employee("test","test","test","test","test");

    @Before
    public void setUp() throws Exception {
        List<Employee> employeeList = Arrays.asList(employee);
        employeeMyBatisMapper  = mock(EmployeeMyBatisMapper.class);
        employeeDao.setEmployeeMyBatisMapper(employeeMyBatisMapper);
        when(employeeMyBatisMapper.findAllEmployees()).thenReturn(employeeList);
        doThrow(RuntimeException.class).when(employeeMyBatisMapper).saveEmployee(Mockito.any(Employee.class));
    }



    @Test
    public void getAll() throws Exception {
        Assert.assertTrue(employee.equals(employeeDao.getAll().get(0)));
    }


    @Test(expected = RuntimeException.class)
    public void save() throws Exception {
        employeeDao.save(employee);
    }

}