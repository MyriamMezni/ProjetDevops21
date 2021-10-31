package tn.esprit.spring.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
@Autowired
IEmployeService ES;

@Test
public void ajouterEmploye()
{
Employe emp=new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
int a=ES.ajouterEmploye(emp);
assertEquals(emp.getId(), a);
}
	


}
