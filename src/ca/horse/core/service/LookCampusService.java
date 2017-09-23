package ca.horse.core.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.horse.core.data.LocationSearchCriteria;
import ca.horse.core.data.LookCampus;
import ca.horse.dao.LookCampusDAO;



@Controller
@RequestMapping("/service/lookcampus")
public class LookCampusService {
	@Autowired private LookCampusDAO lookCampusDAO;
	
	/**
	 * look up campus by id
	 * 
	 * Example url: http://localhost:8080/Horse2/service/lookcampus/1
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<LookCampus> readOne(
			@PathVariable("id") Integer id){
		LookCampus lc = lookCampusDAO.getLookCampusById(id);
		return new ResponseEntity<LookCampus>(lc, HttpStatus.OK);
	}
	
	/**
	 * search campus by criteria
	 * 
	 * available search criteria: cd, name, addresss
	 * 
	 * Example url: http://localhost:8080/Horse2/service/lookcampus?address=scar
	 * 
	 * @param cd
	 * @param name
	 * @param address
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<List<LookCampus>> readSearch(
			@RequestParam(value="cd", required=false) String cd,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="address", required=false)String address){
		
		//build search criteria
		LocationSearchCriteria c = new LocationSearchCriteria
				.LocationSearchCriteriaBuilder()
				.setCd(cd)
				.setName(name)
				.setAddress(address)
				.build();
		
		List<LookCampus> lookCampuses = lookCampusDAO.search(c);
		
		if(lookCampuses == null || lookCampuses.isEmpty()) {
			return new ResponseEntity<List<LookCampus>>(Collections.emptyList(), HttpStatus.OK);
		}else {
			return new ResponseEntity<List<LookCampus>>(lookCampuses, HttpStatus.OK);
		}
		
	}
	
	/**
	 * endpoint for updating a campus definition.
	 * response body must contain an existing campus def with and id defined
	 * 
	 * @param lookCampus
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping("")
	public ResponseEntity update(@RequestBody LookCampus lookCampus){
		//validation(s)
		if(lookCampus == null || lookCampus.getId() == null) {
			return new ResponseEntity<String>("Inappropriate response body", HttpStatus.BAD_REQUEST);
		}
		
		//update and return updated campus def
		LookCampus updatedLookCampus = lookCampusDAO.save(lookCampus);
		return new ResponseEntity<LookCampus>(updatedLookCampus, HttpStatus.OK);
			
	}
	
}
