package tn.esprit.spring.test;

import static org.junit.Assert.*;

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
Employe emp=new Employe("testmyriam", "testmyriam", "testmyriam", true, Role.ADMINISTRATEUR);
int a=ES.ajouterEmploye(emp);
assertEquals(emp.getId(), a);
}
	
@Test
public void ajouterContrat()
{
Contrat C=new Contrat(new Date(), "Contrat annuel myriam", 350);
int a=ES.ajouterContrat(C);
assertEquals(C.getReference(), a);
}


@Test
public void mettreAjourEmailByEmployeId()
{
	String email="new email myriam";
	int employeId=1;
	Employe emp=ER.findById(employeId).get();
	emp.setEmail(email);
	ER.save(emp);
	assertEquals("c'est bon", emp.getId(),employeId );
}



@Test
public void affecterContratAEmploye()
{
	int contratId=20;
	int employeId=1;
	Contrat C=CR.findById(contratId).get();
	Employe emp=ER.findById(employeId).get();
	C.setEmploye(emp);
	CR.save(C);
	assertEquals("c'est bon", emp.getId(),employeId );
}
@Test
public void getEmployePrenomById()
{
	int employeId=1;
String nom=ES.getEmployePrenomById(employeId);
	assertEquals("c'est bon", ES.getEmployePrenomById(employeId),nom );
}


@Test
public void deleteEmployeById()
{
	int employeId=5;
	ES.deleteEmployeById(employeId);
	assertEquals("c'est bon",employeId,5 );
	
}

@Test
public void deleteContratById()
{
	int contratId=20;
	ES.deleteContratById(contratId);
	assertEquals("C'est bon",contratId ,21);

}
@Test
public void getNombreEmployeJPQL()
{
	assertEquals(ES.getNombreEmployeJPQL(),ES.getAllEmployes().size());

}


@Test
public void deleteAllContratJPQL()
{
	ES.deleteAllContratJPQL();
	assertEquals(0,CR.count());

}

}
