package tn.esprit.spring.controller;

import java.util.Date;
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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.ContratDTO;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.EmployeDTO;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlEmploye {

	Logger logger=LogManager.getLogger();
	
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	
	String cst="je vais commencer la recherche";
 
	
	// http://localhost:8081/SpringMVC/servlet/ajouterEmployer
	//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}
	
	@PostMapping("/ajouterEmployer")
	@ResponseBody
	public Employe ajouterEmploye(@RequestBody EmployeDTO employedto)
	{
		Employe employe=new Employe(employedto);
		try {
			logger.info("in ajouter Employe");
			logger.debug("Je vais commencer l'ajout");
			iemployeservice.ajouterEmploye(employe);
			logger.info("out ajouter Employe");
			return employe;
			}
			catch (Exception e) { logger.error("Erreur dans ajouterEmploye() : " , e); }
		
		return employe;
		 
	}
	
	// Modifier email : http://localhost:8081/SpringMVC/servlet/modifyEmail/1/newemail
	@PutMapping(value = "/modifyEmail/{id}/{newemail}") 
	@ResponseBody
	public void mettreAjourEmailByEmployeId(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {
		
		
		try {
			logger.info("in  mettreAjourEmailByEmployeId");
			logger.debug("Je vais commencer la mise à jour");
			iemployeservice.mettreAjourEmailByEmployeId(email, employeId);
			logger.info("out Mise à jour ");
			}
			catch (Exception e) { logger.error("Erreur dans mettreAjourEmailByEmployeId() : " , e); }
		
		
		
	}
	// http://localhost:8081/SpringMVC/servlet/affecterEmployeADepartement/1/1
	@PutMapping(value = "/affecterEmployeADepartement/{idemp}/{iddept}") 
	public void affecterEmployeADepartement(@PathVariable("idemp")int employeId, @PathVariable("iddept")int depId) {
		try {
			logger.info("in  affecterEmployeADepartement");
			logger.debug("Je vais commencer l'affectation");
			iemployeservice.affecterEmployeADepartement(employeId, depId);
			logger.info("out affecterEmployeADepartement ");
			}
			catch (Exception e) { logger.error("Erreur dans affecterEmployeADepartement() : " , e); }
		
		
	}
	
	// http://localhost:8081/SpringMVC/servlet/desaffecterEmployeDuDepartement/1/1
	@PutMapping(value = "/desaffecterEmployeDuDepartement/{idemp}/{iddept}") 
	public void desaffecterEmployeDuDepartement(@PathVariable("idemp")int employeId, @PathVariable("iddept")int depId)
	{
		try {
			logger.info("in  desaffecterEmployeDuDepartement");
			logger.debug("Je vais commencer la desaffectation");
			iemployeservice.desaffecterEmployeDuDepartement(employeId, depId);
			logger.info("out de desaffecterEmployeDuDepartement ");
			}
			catch (Exception e) { logger.error("Erreur dans desaffecterEmployeDuDepartement() : " , e); }
		
		
	}

	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
	//{"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody ContratDTO contratDTO) {	
		Contrat contrat = new Contrat(contratDTO);
		try {
			logger.info("in ajouter Contrat");
			logger.debug("Je vais commencer l'ajout");
			iemployeservice.ajouterContrat(contrat);
			logger.info("out ajouter Contrat ");
			return contrat.getReference();
			}
			catch (Exception e) { logger.error("Erreur dans ajouterContrat() : " , e); }
		
		return contrat.getReference();
		
		
		
		
	}
	
	// http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
   @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
	{
		
		try {
			logger.info("in  affecterContratAEmploye");
			logger.debug("Je vais commencer l'affectation");
			iemployeservice.affecterContratAEmploye(contratId, employeId);
			logger.info("out affecterContratAEmploye ");
			}
			catch (Exception e) { logger.error("Erreur dans affecterContratAEmploye() : " , e); }
		
		
		
	}
	
   
   // URL : http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/2
   @GetMapping(value = "getEmployePrenomById/{idemp}")
   @ResponseBody
   public String getEmployePrenomById(@PathVariable("idemp")int employeId) {
		
 		try {
 			logger.info("in  getEmployePrenomById");
 			logger.debug(cst);
 			logger.info("out de getEmployePrenomById ");
 			return iemployeservice.getEmployePrenomById(employeId);
 			}
 			catch (Exception e) { logger.error("Erreur dans getEmployePrenomById() : " , e); }
 		
 		return iemployeservice.getEmployePrenomById(employeId);

 		
 	}
    // URL : http://localhost:8081/SpringMVC/servlet/deleteEmployeById/1
    @DeleteMapping("/deleteEmployeById/{idemp}") 
	@ResponseBody 
	public void deleteEmployeById(@PathVariable("idemp")int employeId) {	
		try {
			logger.info("in  deleteEmployeById");
			logger.debug("Je vais commencer la supression");
			logger.info("out de deleteEmployeById ");
			iemployeservice.deleteEmployeById(employeId);
			}
			catch (Exception e) { logger.error("Erreur dans deleteEmployeById() : " , e); }
		
		
	}
    
 // URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
    @DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		try {
			logger.info("in  deleteContratById");
			logger.debug("Je vais commencer la supression");
			logger.info("out de deleteContratById ");
			iemployeservice.deleteContratById(contratId);
			}
			catch (Exception e) { logger.error("Erreur dans deleteContratById() : " , e); }
		
	}


    
    // URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "getNombreEmployeJPQL")
    @ResponseBody
public int getNombreEmployeJPQL() {

		try {
			logger.info("in  getNombreEmployeJPQL");
			logger.debug(cst);
			logger.info("out de getNombreEmployeJPQL ");
			return iemployeservice.getNombreEmployeJPQL();
			}
			catch (Exception e) { logger.error("Erreur dans getNombreEmployeJPQL() : " , e); }
		
		return iemployeservice.getNombreEmployeJPQL();

		
		
		
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeNamesJPQL
    @GetMapping(value = "getAllEmployeNamesJPQL")
    @ResponseBody
public List<String> getAllEmployeNamesJPQL() {
		
    	try {
			logger.info("in  getAllEmployeNamesJPQL");
			logger.debug(cst);
			logger.info("out de getAllEmployeNamesJPQL ");
			return iemployeservice.getAllEmployeNamesJPQL();
			}
			catch (Exception e) { logger.error("Erreur dans getAllEmployeNamesJPQL() : " , e); }
		
		return iemployeservice.getAllEmployeNamesJPQL();

		
    	
	}


    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByEntreprise/1
    @GetMapping(value = "getAllEmployeByEntreprise/{identreprise}")
    @ResponseBody
	public List<Employe> getAllEmployeByEntreprise(@PathVariable("identreprise") int identreprise) {
		try {
			logger.info("in  getAllEmployeByEntreprise");
			logger.debug(cst);
	    	Entreprise entreprise=ientrepriseservice.getEntrepriseById(identreprise);
			logger.info("out de getAllEmployeByEntreprise ");
			return iemployeservice.getAllEmployeByEntreprise(entreprise);
			}
			catch (Exception e) { logger.error("Erreur dans getAllEmployeByEntreprise() : " , e); }
    	Entreprise entreprise=ientrepriseservice.getEntrepriseById(identreprise);
		return iemployeservice.getAllEmployeByEntreprise(entreprise);
		
	}


 // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByEmployeIdJPQL/2/newemail
 	@PutMapping(value = "/mettreAjourEmailByEmployeIdJPQL/{id}/{newemail}") 
 	@ResponseBody
 	public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {	
 		
 		try {
 			logger.info("in  mettreAjourEmailByEmployeIdJPQL");
 			logger.debug("Je vais commencer la mise à jour");
 			iemployeservice.mettreAjourEmailByEmployeIdJPQL(email, employeId);
 			logger.info("out Mise à jour ");
 			}
 			catch (Exception e) { logger.error("Erreur dans mettreAjourEmailByEmployeIdJPQL() : " , e); }
 		
 		
 		
 		}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
    @DeleteMapping("/deleteAllContratJPQL") 
	@ResponseBody
	public void deleteAllContratJPQL() {
		
		try {
			logger.info("in  deleteAllContratJPQL");
			logger.debug("Je vais commencer la suppression");
			iemployeservice.deleteAllContratJPQL();
			logger.info("out deleteAllContratJPQL ");
			}
			catch (Exception e) { logger.error("Erreur dans deleteAllContratJPQLsq() : " , e); }
		
		
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByEmployeIdJPQL/2
    @GetMapping(value = "getSalaireByEmployeIdJPQL/{idemp}")
    @ResponseBody
	public float getSalaireByEmployeIdJPQL(@PathVariable("idemp")int employeId) {
    	try {
			logger.info("in  getSalaireByEmployeIdJPQL");
			logger.debug(cst);
	    
			logger.info("out de getSalaireByEmployeIdJPQL ");
			return iemployeservice.getSalaireByEmployeIdJPQL(employeId);
			}
			catch (Exception e) { logger.error("Erreur dans getSalaireByEmployeIdJPQL() : " , e); }
		return iemployeservice.getSalaireByEmployeIdJPQL(employeId);
	
		
		
		
		
	}
    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireMoyenByDepartementId/2
    @GetMapping(value = "getSalaireMoyenByDepartementId/{iddept}")
    @ResponseBody
public Double getSalaireMoyenByDepartementId(@PathVariable("iddept")int departementId) {
	
    	{

		try {
			logger.info("in  getSalaireMoyenByDepartementId");
			logger.debug(cst);
	    
			logger.info("out de getSalaireMoyenByDepartementId ");
			return iemployeservice.getSalaireMoyenByDepartementId(departementId);
			}
			catch (Exception e) { logger.error("Erreur dans getSalaireMoyenByDepartementId() : " , e); }
		return iemployeservice.getSalaireMoyenByDepartementId(departementId);
	}
	
		
    
    }


	
	//TODO
    public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {

	
		try {
			logger.info("in  getTimesheetsByMissionAndDate");
			logger.debug(cst);
	    
			logger.info("out de getTimesheetsByMissionAndDate ");
			return iemployeservice.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
			}
			catch (Exception e) { logger.error("Erreur dans getTimesheetsByMissionAndDate() : " , e); }
		return iemployeservice.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	
	}

	 // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployes
	@GetMapping(value = "/getAllEmployes")
    @ResponseBody
public List<Employe> getAllEmployes() {
		
	
		
		try {
			logger.info("in  getAllEmployes");
			logger.debug(cst);
	    
			logger.info("out de getAllEmployes ");
			return iemployeservice.getAllEmployes();
			}
			catch (Exception e) { logger.error("Erreur dans getAllEmployes() : " , e); }
		return iemployeservice.getAllEmployes();

		
	}
	
	
}
