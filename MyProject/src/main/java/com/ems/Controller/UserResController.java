package com.ems.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.Exception.ResourceNotFoundException;
import com.ems.Model.User;
import com.ems.Service.UserService;

@RestController
public class UserResController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/userSave")
	public String userSave(@RequestBody @Valid User user)
	{
		try
		{
			
			String pass= user.getPassword();
			String cPass=user.getConfirmPassword();
			if(pass.equals(cPass))
			{
		userservice.save(user);
		return "Data Saved Succesfully";
			}
			else
			{
		return "PASSWORD MISSMATCH";
			}
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("SAved FAiled");
		}
	}
	
	
	
	
}
