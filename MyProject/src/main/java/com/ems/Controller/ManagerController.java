package com.ems.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.Model.ManagerModel;
import com.ems.Service.ManagerService;

@Controller
public class ManagerController {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);
	
    @Autowired
	ManagerService manService;

	@PostMapping("/saveManager")
	public ResponseEntity<Integer> saveManager(@RequestBody ManagerModel model) {
		log.info("Save Manager");
		return new ResponseEntity<Integer>(manService.save(model), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getallmanager")
	public ResponseEntity<List<ManagerModel>> getAllEmployee() {
		log.info("Get All manager");
		return new ResponseEntity<List<ManagerModel>>(manService.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/managerfindByid/{id}")
	public ManagerModel findById(@PathVariable int id) {
		log.info("Find manager By Id");
		return manService.findById(id);
	}
}
