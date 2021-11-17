package tn.esprit.spring.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ITimesheetService;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetTest {

	
	@Autowired
	ITimesheetService timerServ;
	
	@Test
	public void ajouterMissionTest(){
		 Mission m = new Mission("mission name", "desc mission");
		 int t = timerServ.ajouterMission(m);
		 assertEquals(m.getId(), t);
	
	}
	

	
	
	
	@Test
	public void findAllMissionByEmployeJPQLtest(){
		
		Timesheet timesheet  = new Timesheet();
		Employe emp = new Employe();
		timesheet.setEmploye(emp);
		timerServ.findAllMissionByEmployeJPQL(timesheet.getEmploye().getId());
		assertEquals(emp.getId(),timesheet.getEmploye().getId());	
		
	}
	
	@Test
	public void getAllEmployeByMission(){
		
		Timesheet timesheet  = new Timesheet();
		Mission mission = new Mission();
		timesheet.setMission(mission);
		timerServ.getAllEmployeByMission(timesheet.getMission().getId());
		assertEquals(mission.getId(),timesheet.getMission().getId());
		
		
	}
	
}
