package com.ems.Service.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ems.Exception.ResourceNotFoundException;
import com.ems.Model.EmployeeModel;
import com.ems.Service.EmployeeService;

@Component
public class EmployeeServiceImp implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImp.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	@Override
	public void save(EmployeeModel empModel) {
		log.info("Save Started");

		try {
			jdbcTemplate.update(
					"insert into employee_model (id, emp_address,emp_age,emp_man,emp_name,emp_salary)"
							+ "values(?,?,?,?,?,?)",
					empModel.getId(), empModel.getEmpAddress(), empModel.getEmpAge(), empModel.getEmpMan(),
					empModel.getEmpName(), empModel.getEmpSalary());

		} catch (Exception e) {

			throw new ResourceNotFoundException("Save failed");
		}
	}

	
	
	@Override
	public String deleteById(Long id) {

		jdbcTemplate.update("delete from employee_model where id = ?", id);

		return "deleted employee where id=" + id;

	}

	
	
	@Override
	public List<EmployeeModel> findByManager(String name) {
		try {
			return jdbcTemplate.query("SELECT * from employee_model WHERE emp_man=?",
					BeanPropertyRowMapper.newInstance(EmployeeModel.class), name);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Not found Employee with id = " + name);
		}
	}

	
	
	@Override
	public EmployeeModel findById(Long id) {
		try {

			return jdbcTemplate.queryForObject("SELECT * from employee_model WHERE id=?",

					BeanPropertyRowMapper.newInstance(EmployeeModel.class), id);

		} catch (Exception e) {
			throw new ResourceNotFoundException("Not found Employee with id = " + id);
		}

	}

	
	
	@Override
	public List<EmployeeModel> findAll() {
		return jdbcTemplate.query("SELECT * from employee_model ",
				BeanPropertyRowMapper.newInstance(EmployeeModel.class));
	}

	
	
	@Override
	public int update(EmployeeModel e, int id) {
		return jdbcTemplate.update(
				"UPDATE employee_model SET emp_address = ?, emp_age = ?, emp_man = ? ,emp_name = ?, emp_salary WHERE id = ?",
				new Object[] { e.getEmpAddress(), e.getEmpAge(), e.getEmpMan(), e.getEmpName(), e.getEmpSalary(), id });
	}

	
}
