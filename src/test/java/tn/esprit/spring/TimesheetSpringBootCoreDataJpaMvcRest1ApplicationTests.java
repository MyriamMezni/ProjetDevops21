package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.EmployeServiceImplTest;




@SpringBootTest
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests {
	  
@Autowired
EmployeServiceImplTest es;

	@Test
	void contextLoads(){
		es.ajouterContrat();
	}

}
