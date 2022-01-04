package com.ems.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Exception.ResourceNotFoundException;
import com.ems.Model.EmployeeModel;
import com.ems.Service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Controller
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService empService;

	@PostMapping("/saveEmployee")
	public void saveEmployee(@Valid @RequestBody EmployeeModel model) {
		log.info("Save Employee");

		empService.save(model);

	}

	@PostMapping("/getEmployeeById")
	@Cacheable(value = "Employee",key = "id")
	public ResponseEntity<?> getEmployeeById(@RequestParam("id") Long id) {
		EmployeeModel employeeModel= empService.findById(id);
		if(employeeModel!=null)
		{			
			return new ResponseEntity<>(employeeModel,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(new ResourceNotFoundException("Id Not found"),HttpStatus.OK);
		}
	}

	
	
	
	
	
	
	@PostMapping("/deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam("id") Long id) {

		EmployeeModel employeeModel= empService.findById(id);
		if(employeeModel!=null)
		{
			return empService.deleteById(id);

		
		}
		else {

			throw new ResourceNotFoundException("Not found Employee with id = " + id);

		}

	}
	
	
	
	
	@PostMapping("/findByManager")
	public ResponseEntity<List<EmployeeModel>> findByManager(@RequestParam("name") String name) {

		try {
			return new ResponseEntity<List<EmployeeModel>>(empService.findByManager(name), HttpStatus.OK);
		} catch (Exception e) {

			throw new ResourceNotFoundException("Not found Employee with id = " + name);

		}
	}
	
	
	
	
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeModel>>(empService.findAll(), HttpStatus.OK);

	}

	

	

	@PutMapping("/employeeUpdate/{id}")
	public String update(@RequestBody EmployeeModel e, @PathVariable int id) {
		try {
			return empService.update(e, id) + " Employee(s) updated successfully";
		} catch (Exception ex) {

			throw new ResourceNotFoundException("not valida data");
		}

	}

}
