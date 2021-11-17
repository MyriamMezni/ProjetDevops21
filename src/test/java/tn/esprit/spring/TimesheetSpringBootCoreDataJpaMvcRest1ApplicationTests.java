package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.EmployeServiceImplTest;


@SpringBootTest
 class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests {
	EmployeServiceImplTest ES;
	@Test 
	void contextLoads()
	{ 
		ES.ajouterEmployeTest();
	
	} 
	
}
