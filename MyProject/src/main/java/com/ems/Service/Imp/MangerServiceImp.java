package com.ems.Service.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ems.Model.ManagerModel;
import com.ems.Service.ManagerService;

@Component
public class MangerServiceImp implements ManagerService {

	private static final Logger log = LoggerFactory.getLogger(ManagerService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(ManagerModel manModel) {
		log.info("Save Started");
		return jdbcTemplate.update(
				"insert into manager_model (id, current_project,man_address,man_age,man_name,man_salary)"
						+ "values(?,?,?,?,?,?)",
				manModel.getId(), manModel.getCurrentProject(), manModel.getManAddress(), manModel.getManAge(),
				manModel.getManName(), manModel.getManSalary());

	}

	@Override
	public List<ManagerModel> findAll() {

		log.info("Find all manager Started");
		return jdbcTemplate.query("select * from manager_model",
				(rs, rowNum) -> new ManagerModel(rs.getLong("id"), rs.getString("man_name"), rs.getString("man_age"),
						rs.getString("man_address"), rs.getString("man_salary"), rs.getString("current_project")

				));
	}

	@Override
	public ManagerModel findById(int id) {
		return (ManagerModel) jdbcTemplate.queryForList("SELECT * FROM tbl_employees WHERE id=?",
				new BeanPropertyRowMapper<ManagerModel>(), id);
	}

}
