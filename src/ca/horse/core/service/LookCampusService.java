package ca.horse.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.horse.core.data.LookCampus;
import ca.horse.dao.LookCampusDAO;



@Controller
@RequestMapping("/service/lookcampus")
public class LookCampusService {
	@Autowired private LookCampusDAO lookCampusDAO;
	
	//http://localhost:8080/Horse2/service/lookcampus/1
	@GetMapping("/{id}")
	public ResponseEntity<LookCampus> readOne(
			@PathVariable("id") Integer id){
		LookCampus lc = lookCampusDAO.getLookCampusById(id);
		return new ResponseEntity<LookCampus>(lc, HttpStatus.OK);
	}
	
}
