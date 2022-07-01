package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
//----------------------------------------------------------------	
	
	public UserModel saveUserModel(UserModel usermodel) {
		return repository.save(usermodel);
		
	}
	
	public List<UserModel> saveUserModels(List<UserModel> usermodels) {
		return  repository.saveAll(usermodels);
		
	}
	
//---------------------------------------------------------------
	
	public List<UserModel> getUserModel(){
		return repository.findAll();
	}
	
	public UserModel getUserModelById(int uid){
		return repository.findById(uid).orElse(null);
	}
	
//----------------------------------------------------------------	

	public String deleteUserModel(int uid) {
		repository.deleteById(uid);
		return "removed"+uid;
	}
	
//----------------------------------------------------------------	
	
	
	public UserModel updateUserModel(UserModel usermodel) {
		UserModel existing=repository.findById(usermodel.getId()).orElse(null);
		existing.setId(usermodel.getId());
		existing.setUserName(usermodel.getUserName());
		existing.setEmail(usermodel.getEmail());
		existing.setPhone(usermodel.getPhone());
		existing.setPassword(usermodel.getPassword());
		return repository.save(existing);
		
		
	}

}
