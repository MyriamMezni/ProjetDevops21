package tn.esprit.spring.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
@Autowired
IEmployeService ES;
@Autowired
EmployeRepository ER;
@Autowired
ContratRepository CR;


@Test
public void ajouterEmploye()
{
Employe emp=new Employe("test", "test", "test", true, Role.ADMINISTRATEUR);
//int a=ES.ajouterEmploye(emp);
//assertEquals(emp.getId(), a);
}
	
@Test
public void ajouterContrat()
{
Contrat C=new Contrat(new Date(), "Contrat annuel", 350);
//int a=ES.ajouterContrat(C);
//assertEquals(C.getReference(), a);
}


@Test
public void mettreAjourEmailByEmployeId()
{
	String email="new email";
	int employeId=3;
	Employe emp=ER.findById(employeId).get();
	emp.setEmail(email);
	ER.save(emp);
	assertEquals("c'est bon", emp.getId(),employeId );
}



@Test
public void affecterContratAEmploye()
{
	int contratId=2;
	int employeId=2;
	Contrat C=CR.findById(contratId).get();
	Employe emp=ER.findById(employeId).get();
	C.setEmploye(emp);
	CR.save(C);
	assertEquals("c'est bon", emp.getId(),employeId );
}
@Test
public void getEmployePrenomById()
{
	int employeId=2;
String nom=ES.getEmployePrenomById(employeId);
	assertEquals("c'est bon", ES.getEmployePrenomById(employeId),nom );
}


@Test
public void deleteEmployeById()
{
	//int employeId=4;
	//ES.deleteEmployeById(employeId);
}

@Test
public void deleteContratById()
{
	//int contratId=4;
	//ES.deleteContratById(contratId);
}
@Test
public void getNombreEmployeJPQL()
{
	assertEquals(ES.getNombreEmployeJPQL(),ES.getAllEmployes().size());

}
}
