package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.EmployeServiceImplTest;

import org.junit.Test;

@SpringBootTest
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests {
	  
	@Autowired
	EmployeServiceImplTest ES;
	


	@Test
  void contextLoads(){
	  ES.ajouterContrat();
  }

}
