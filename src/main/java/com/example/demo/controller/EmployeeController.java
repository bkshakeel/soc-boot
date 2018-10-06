package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Component
@Path("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GET
    @Produces("application/json")
    @Path("employees")

    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @POST
    @Path("employee")
    public Response postStudents(Employee employee){
        try {
            employeeService.saveEmployee(employee);
            return Response.status(201).entity("created").build();
        }
        catch (RuntimeException e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
