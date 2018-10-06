package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

    private Employee employee =  new Employee("test","test","test","test","test");
    private EmployeeDao employeeDao;
    private EmployeeServiceImpl employeeService= new EmployeeServiceImpl();

    @Before
    public void setUp() throws Exception {
        List<Employee> employeeList = Arrays.asList(employee);
        employeeDao=mock(EmployeeDao.class);
        employeeService.setEmployeeDao(employeeDao);
        when(employeeDao.getAll()).thenReturn(employeeList);
        doThrow(RuntimeException.class).when(employeeDao).save(any(Employee.class));

    }

    @Test
    public void getAllEmployees() throws Exception {
        assertTrue(employee.equals(employeeService.getAllEmployees().get(0)));
    }
    @Test(expected = RuntimeException.class)
    public void getAllEmployeesException() throws Exception {
        doThrow(RuntimeException.class).when(employeeDao).getAll();
        employeeService.getAllEmployees();
    }

    @Test(expected = RuntimeException.class)
    public void saveEmployee() throws Exception {
        employeeService.saveEmployee(employee);
    }

}