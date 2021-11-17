package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.services.EmployeServiceImplTest;

@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {

	public static void main(String[] args) {
	
		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1Application.class, args);
	}

	
}
