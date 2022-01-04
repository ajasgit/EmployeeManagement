package com.ems.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Model.ProjectModel;
import com.ems.Service.ProjectService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@Controller
public class ProjectController {

	@Autowired
	private ProjectService proService;

	@PostMapping("/saveProject")
	public ResponseEntity<Integer> saveProject(@RequestBody ProjectModel model) {

		 return new ResponseEntity<Integer>(proService.save(model), HttpStatus.OK);

	}

	@GetMapping("/getallproject")
	public ResponseEntity<List<ProjectModel>> getAllProject() {
		return new ResponseEntity<List<ProjectModel>>(proService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/findByProjectName")
	public ResponseEntity<List<ProjectModel>> findByProjectName(@RequestParam("name") String name) {
		return new ResponseEntity<List<ProjectModel>>(proService.findByProjectName(name), HttpStatus.OK);
	}

	@GetMapping("/findHighestId")
	public ResponseEntity<List<ProjectModel>> findHighestId() {
		return new ResponseEntity<List<ProjectModel>>(proService.findHighestId(), HttpStatus.OK);
	}

}
