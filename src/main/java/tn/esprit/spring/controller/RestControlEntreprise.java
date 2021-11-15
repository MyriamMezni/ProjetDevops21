package tn.esprit.spring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlEntreprise {

	Logger logger=LogManager.getLogger();
	
	String cst="je vais commencer la recherche";

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	
	// Ajouter Entreprise : http://localhost:8081/SpringMVC/servlet/ajouterEntreprise
	//{"id":1,"name":"SSII Consulting","raisonSocial":"Cite El Ghazela"}

	@PostMapping("/ajouterEntreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Entreprise ssiiConsulting) {
		
		
		ientrepriseservice.ajouterEntreprise(ssiiConsulting);
		try {
			logger.info("in ajouterEntreprise");
			logger.debug("Je vais commencer l'ajout");
			ientrepriseservice.ajouterEntreprise(ssiiConsulting);
			logger.info("out ajouterEntreprise");
			return ssiiConsulting.getId();
			}
			catch (Exception e) { logger.error("Erreur dans ajouterEntreprise() : " , e); }
		
		return ssiiConsulting.getId();
	}
	
	// http://localhost:8081/SpringMVC/servlet/affecterDepartementAEntreprise/1/1
    @PutMapping(value = "/affecterDepartementAEntreprise/{iddept}/{identreprise}") 
	public void affecterDepartementAEntreprise(@PathVariable("iddept")int depId, @PathVariable("identreprise")int entrepriseId) {
		ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
		try {
			logger.info("in  affecterDepartementAEntreprise");
			logger.debug("Je vais commencer l'affectation");
			ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
			logger.info("out affecterDepartementAEntreprise ");
			}
			catch (Exception e) { logger.error("Erreur dans affecterDepartementAEntreprise() : " , e); }
	}
    
    // http://localhost:8081/SpringMVC/servlet/deleteEntrepriseById/1
    @DeleteMapping("/deleteEntrepriseById/{identreprise}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("identreprise")int entrepriseId)
	{
		ientrepriseservice.deleteEntrepriseById(entrepriseId);
		
		try {
			logger.info("in  deleteEntrepriseById");
			logger.debug("Je vais commencer la supression");
			logger.info("out de deleteEntrepriseById ");
			ientrepriseservice.deleteEntrepriseById(entrepriseId);
			}
			catch (Exception e) { logger.error("Erreur dans deleteEntrepriseById() : " , e); }
	}
    
    // http://localhost:8081/SpringMVC/servlet/getEntrepriseById/1
    @GetMapping(value = "getEntrepriseById/{identreprise}")
    @ResponseBody
	public Entreprise getEntrepriseById(@PathVariable("identreprise") int entrepriseId) {
    	{

		try {
			logger.info("in  getEntrepriseById");
			logger.debug(cst);
	    
			logger.info("out de getEntrepriseById ");
			return ientrepriseservice.getEntrepriseById(entrepriseId);
			}
			catch (Exception e) { logger.error("Erreur dans getEntrepriseById() : " , e); }
		return ientrepriseservice.getEntrepriseById(entrepriseId);
	}}
    
    // http://localhost:8081/SpringMVC/servlet/ajouterDepartement
 	//{"id":1,"name":"Telecom"}

 	@PostMapping("/ajouterDepartement")
 	@ResponseBody
	public int ajouterDepartement(@RequestBody Departement dep) {
		 ientrepriseservice.ajouterDepartement(dep);
			try {
				logger.info("in ajouterDepartement");
				logger.debug("Je vais commencer l'ajout");
				ientrepriseservice.ajouterDepartement(dep);
				logger.info("out ajouterDepartement");
				return dep.getId();
				}
				catch (Exception e) { logger.error("Erreur dans ajouterDepartement() : " , e); }
		return dep.getId();
		
		
	}
	
 	 // http://localhost:8081/SpringMVC/servlet/getAllDepartementsNamesByEntreprise/1
    @GetMapping(value = "getAllDepartementsNamesByEntreprise/{identreprise}")
    @ResponseBody
	public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("identreprise") int entrepriseId) {
		
    	try {
			logger.info("in  getAllDepartementsNamesByEntreprise");
			logger.debug(cst);
			logger.info("out de getAllDepartementsNamesByEntreprise ");
			return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
			}
			catch (Exception e) { logger.error("Erreur dans getAllDepartementsNamesByEntreprise() : " , e); }
		
    	return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteDepartementById/3
    @DeleteMapping("/deleteDepartementById/{iddept}") 
	@ResponseBody 
	public void deleteDepartementById(@PathVariable("iddept") int depId) {
		ientrepriseservice.deleteDepartementById(depId);
		
		try {
			logger.info("in  deleteDepartementById");
			logger.debug("Je vais commencer la supression");
			logger.info("out de deleteDepartementById ");
			ientrepriseservice.deleteDepartementById(depId);
			}
			catch (Exception e) { logger.error("Erreur dans deleteDepartementById() : " , e); }

	}
}
