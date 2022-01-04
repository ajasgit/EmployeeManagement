package com.ems.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ems.Exception.ResourceNotFoundException;
import com.ems.Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class userServiceImp implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			// JSONObject jSon=new JSONObject(user);
			// System.out.println(jSon.get("addresses").toString());

			// String ss=objectMapper.writeValueAsString(user.getAddress());

			jdbcTemplate.update(
					"insert into user (first_name,last_name,name_offather,password,phone,user_name,address)"
							+ " values(?,?,?,?,?,?,?)",
					user.getFirstName(), user.getLastName(), user.getNameOffather(), user.getPassword(),
					user.getPhone(), user.getUserName(), objectMapper.writeValueAsString(user.getAddress()));

		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println(objectMapper.writeValueAsString(user.getAddress()));
			throw new ResourceNotFoundException("Save failed");
		}
	}

	

	
	
	
}
