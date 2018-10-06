package com.example.demo;

import com.example.demo.mappers.EmployeeMyBatisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {

		employeeMyBatisMapper.findAllEmployees().forEach(x->{
			logger.info("Student id 10001 -> {}",x.getFirstName() );
		});

	}*/
}