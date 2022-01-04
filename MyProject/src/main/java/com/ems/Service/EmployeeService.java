package com.ems.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.Model.EmployeeModel;

@Service
public interface EmployeeService {

	public void save(EmployeeModel empModel);

	public List<EmployeeModel> findAll();

	public  EmployeeModel findById(Long id);

	public List<EmployeeModel> findByManager(String name);

	public String deleteById(Long id);

	public int update(EmployeeModel e, int id);

}
