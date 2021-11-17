package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.EmployeServiceImplTest;

import org.junit.*;

@SpringBootTest
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTest {
	  
	@Autowired
	EmployeServiceImplTest ES;
	


	@Test
  void contextLoads(){
	  ES.ajouterContrat();
  }

}
