package tn.esprit.spring;

import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.test.EmployeTest;

import org.junit.Test;

@SpringBootTest
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests {

	EmployeTest ES;
	@Test
  void contextLoads(){
	  ES.ajouterContrat();
	  ES.ajouterEmploye();
	  
  }

}
