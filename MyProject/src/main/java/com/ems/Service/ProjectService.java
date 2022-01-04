package com.ems.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.Model.ProjectModel;

@Service
public interface ProjectService {

	
	public int save(ProjectModel proModel);
	
	 public List<ProjectModel> findAll();
	 
	 public List<ProjectModel> findByProjectName(String name);
	 
	 public List<ProjectModel> findHighestId();
	
}
