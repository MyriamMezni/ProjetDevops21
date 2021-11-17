package tn.esprit.spring.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {

	@Autowired
	IEntrepriseService ES;
	@Autowired
	EntrepriseRepository ER;
	@Autowired
	DepartementRepository DR;
	
	
	@Test
	public void ajouterEntreprise()
	{
	Entreprise entr=new Entreprise("testameni", "testameni");
	int a=ES.ajouterEntreprise(entr);
	assertEquals(entr.getId(), a);
	}
	
	
	@Test
	public void ajouterDepartement()
	{
	Departement dep=new Departement("testameni");
	int a=ES.ajouterDepartement(dep);
	assertEquals(dep.getId(), a);
	}
	
	@Test
	public void affecterDepartementAEntreprise()
	{
		int departementId=20;
		int entrepriseId=1;
		Departement C=DR.findById(departementId).get();
		Entreprise entr=ER.findById(entrepriseId).get();
		C.setEntreprise(entr);
		DR.save(C);
		assertEquals("c'est bon", entr.getId(),entrepriseId );
	}	
	 
	@Test
	public void getAllDepartementsNamesByEntreprise()
	{ 
		int entrepriseId=1;
	List<String> nom=ES.getAllDepartementsNamesByEntreprise(entrepriseId);
		assertEquals("c'est bon", ES.getEntrepriseById(entrepriseId),nom );
	}
	

	
	

	

}
