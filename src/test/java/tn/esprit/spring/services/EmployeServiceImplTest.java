package tn.esprit.spring.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class EmployeServiceImplTest {
	Logger logger=LogManager.getLogger();
@Autowired
IEmployeService ES;
@Autowired
EmployeRepository ER;
@Autowired
ContratRepository CR;
 
String cst="je vais commencer la recherche";

          
@Test
public void testajouterEmploye()
{
	try {
		logger.trace("debut du log");
		logger.info("in ajouter Employe");
		logger.debug("Je vais commencer l'ajout");
		Employe emp=new Employe("testmyriam1", "testmyriam2", "testmyriam3", true, Role.ADMINISTRATEUR);
		int a=ES.ajouterEmploye(emp);
		assertEquals(emp.getId(), a);
		logger.info("out ajouter Employe");
	}
	catch (Exception e) { logger.error("Erreur dans ajouterEmploye() : " , e); }

}
	
@Test
public void ajouterContrat()
{
Contrat con=new Contrat(new Date(), "Contrat annuel myriam", 350);
int a=ES.ajouterContrat(con);
assertEquals(con.getReference(), a);
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
public void getEmployePrenomById()
{
	int employeId=1;
String nom=ES.getEmployePrenomById(employeId);
	assertEquals("c'est bon", ES.getEmployePrenomById(employeId),nom );
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
