package com.example.demo.controller;

import com.example.demo.mappers.EmployeeMyBatisMapper;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    private EmployeeService employeeService;
    private EmployeeController employeeController = new EmployeeController();
    private Employee employee =  new Employee("test","test","test","test","test");

    @Before
    public void setUp() throws Exception {
        List<Employee> employeeList = Arrays.asList(employee);
        employeeService  = mock(EmployeeService.class);
        employeeController.setEmployeeService(employeeService);
        when(employeeService.getAllEmployees()).thenReturn(employeeList);
        doThrow(RuntimeException.class).when(employeeService).saveEmployee(Mockito.any(Employee.class));

    }


    @Test
    public void getAllEmployees() throws Exception {
        assertTrue(employee.equals(employeeController.getEmployees().get(0)));
    }


    @Test
    public void save() throws Exception {
        Assert.assertEquals(Integer.parseInt(HttpStatus.BAD_REQUEST.toString()),employeeController.postStudents(employee).getStatus());
    }

}