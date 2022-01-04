package com.ems.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ems.Model.ProjectModel;
import com.ems.Service.ProjectService;


@Component
public class ProjectServiceImp implements ProjectService {

	
	@Autowired
	JdbcTemplate jdbcProject;
	
	
	

	@Override
	public int save(ProjectModel proModel) {
		
		return jdbcProject.update(
	                "insert into project_model (id, f_date,p_name,s_date)"
	                + "values(?,?,?,?)",
	                proModel.getId(), 
	                proModel.getfDate(),
	                proModel.getpName(),
	                proModel.getsDate());
	             
	}




	@Override
	public List<ProjectModel> findAll() {
		return jdbcProject.query("SELECT * from project_model ",
				BeanPropertyRowMapper.newInstance(ProjectModel.class));
	}




	@Override
	public List<ProjectModel> findByProjectName(String name) {
		return jdbcProject.query("SELECT * from project_model WHERE p_name=?",
				BeanPropertyRowMapper.newInstance(ProjectModel.class), name);
	}
	
	
	@Override
	public List<ProjectModel> findHighestId() {
		return jdbcProject.query("SELECT * from project_model where id=(select max(id) from project_model) ",
				BeanPropertyRowMapper.newInstance(ProjectModel.class));
	}
	
	
}
