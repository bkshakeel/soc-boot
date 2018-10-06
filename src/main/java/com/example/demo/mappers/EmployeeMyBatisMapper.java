package com.example.demo.mappers;

import com.example.demo.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMyBatisMapper {

    @Select("SELECT * FROM employee")
    public List<Employee> findAllEmployees();

    @Insert("INSERT INTO employee(firstName, lastName, gender,dob,department) VALUES (#{firstName}, #{lastName}, #{gender},#{dob}, #{department})")
    public void saveEmployee(Employee employee);

}
