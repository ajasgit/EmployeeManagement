package com.ems.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.Model.ManagerModel;

@Service
public interface ManagerService {
	
	public int save(ManagerModel manModel);

	 public List<ManagerModel> findAll();
	 
	 public ManagerModel findById(int id);
}
