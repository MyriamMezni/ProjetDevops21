package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionDTO;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlTimesheet {
	
	Logger logger=LogManager.getLogger();
	
@Autowired
EmployeRepository er;
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;
	
	
	
	
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterMission
	@PostMapping("/ajouterMission")
	@ResponseBody
	public int ajouterMission(@RequestBody MissionDTO missiondto) {
		 Mission mission = new Mission(missiondto);
		try {
			logger.info("in ajouter Mission");
			logger.debug("Je vais commencer l'ajout");
			itimesheetservice.ajouterMission(mission);
			logger.info("out ajouter Mission");
			return mission.getId();
			}
		catch (Exception e) { logger.error("Erreur dans ajouterMission() : " , e); }
		return mission.getId();
	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}") 
	public void affecterMissionADepartement(@PathVariable("idmission") int missionId, @PathVariable("iddept") int depId) {
	
		
		try {
			logger.info("in  affecter MissionADepartement");
			logger.debug("Je vais commencer l'affectation");
			itimesheetservice.affecterMissionADepartement(missionId, depId);
			logger.info("out affecterMissionADepartement ");
			}
			catch (Exception e) { logger.error("Erreur dans affecterMissionADepartement() : " , e); }
		

	}
	
	// http://localhost:8081/SpringMVC/servlet/ajouterTimesheet
    //hetha tzidou f postman ma acolade "missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"
	
	@PostMapping("/ajouterTimesheet/idmission/idemp/dated/datef")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable("idmission") int missionId, @PathVariable("idemp") int employeId, @PathVariable("dated") Date dateDebut,@PathVariable("datef") Date dateFin) {
		
		
		itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
		try {
			logger.info("in ajouter Timesheet");
			logger.debug("Je vais commencer l'ajout");
			itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
			logger.info("out ajouter Timesheet");
			
			}
		catch (Exception e) { logger.error("Erreur dans ajouterTimesheet() : " , e); }
		
	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/validerTimesheet/{idmission}/{iddept}") 
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		
		itimesheetservice.validerTimesheet(missionId, employeId, dateDebut, dateFin,validateurId);
		try {
			logger.info("in valider Timesheet");
			logger.debug("Je vais commencer la validation");
			itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
			logger.info("out validation Timesheet");
			
			}
		catch (Exception e) { logger.error("Erreur dans validerTimesheet() : " , e); }

	}
	
	// URL : http://localhost:8081/SpringMVC/servlet/findAllMissionByEmployeJPQL/1
    @GetMapping(value = "findAllMissionByEmployeJPQL/{idemp}")
    @ResponseBody
	public List<Mission> findAllMissionByEmployeJPQL(@PathVariable("idemp") int employeId) {
		
		
		try {
			logger.info("in  findAllMissionByEmployeJPQL");
			logger.debug("Je vais commencer la recherche");
			logger.info("out de findAllMissionByEmployeJPQL ");
			return itimesheetservice.findAllMissionByEmployeJPQL(employeId);
			}
			catch (Exception e) { logger.error("Erreur dans getAllEmployeByEntreprise() : " , e); }
    	return itimesheetservice.findAllMissionByEmployeJPQL(employeId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByMission/1
    @GetMapping(value = "getAllEmployeByMission/{idmission}")
    @ResponseBody
	public List<Employe> getAllEmployeByMission(@PathVariable("idmission") int missionId) {

		
		
		try {
			logger.info("in  getAllEmployeByEntreprise");
			logger.debug("Je vais commencer la recherche");
			logger.info("out de getAllEmployeByEntreprise ");
			return itimesheetservice.getAllEmployeByMission(missionId);
			}
			catch (Exception e) { logger.error("Erreur dans getAllEmployeByMission() : " , e); }
		return itimesheetservice.getAllEmployeByMission(missionId);
		
	}
}
