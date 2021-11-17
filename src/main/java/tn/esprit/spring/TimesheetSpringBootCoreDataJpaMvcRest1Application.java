package tn.esprit.spring;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.esprit.spring.test.EmployeTest;

@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests.class, args);
	}

	EmployeTest ES;
	@Test
  void contextLoads(){
	  ES.ajouterContrat();
	  ES.ajouterEmploye();
	   
  }
}
