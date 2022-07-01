package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.ProductService;

@RestController
public class UserRestController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addUser")
	public UserModel addProduct(@RequestBody UserModel usermodel) {
		return service.saveUserModel(usermodel);
	}
	
	@PostMapping("/addUsers")
	public List<UserModel> addProducts(@RequestBody List<UserModel> usermodels) {
		return service.saveUserModels(usermodels);
	}

	
	
	@GetMapping("/Users")
	public List<UserModel> findAllUserModel(){
		return service.getUserModel();
	}

	@GetMapping("/User/{uid}")
	public UserModel findUserModelById(@PathVariable int uid){
		return service.getUserModelById(uid);
	}

	@PutMapping("/updateUser")
	public UserModel updateProduct(@RequestBody UserModel usermodel) {
		return service.updateUserModel(usermodel);
	}
	
	@DeleteMapping("delete/{uid}")
	public String deleteUserModel(@PathVariable int uid) {
		return service.deleteUserModel(uid);
	}
}
