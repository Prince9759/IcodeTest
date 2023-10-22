package com.files.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.files.Service.UserService;
import com.files.entity.User;
import com.files.entity.employee;
import com.files.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController 
{
//	@Autowired
//	private UserRepository ur;
//	  @PostMapping("/adduser")
//	    public String saveUser(@RequestBody User user){
//	        ur.save(user);
//	       
//	        return "Added Successfully";
//	    }
//	  
//	   @GetMapping("/findAllUser")
//	    public List<User> getUsers() {
//	       
//	        return ur.findAll();
//	    }
//	  
	
	@Autowired
	private UserService us;
	
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody User user) 
	{
		return us.signIn(user);
	}
	@PostMapping(value = "signInemp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signInemp(@RequestBody employee emp) 
	{
		return us.signInEmp(emp);
	}
	@PostMapping(value = "signUp")
	public String signUp(@RequestBody User user) 
	{
		System.out.println(user+"gtjhbnk");
		return us.signUp(user);
	}
	
	@GetMapping(value="getUserByCompanyName/{companyName}")
	public int getUserByCompany(@PathVariable("companyName") String companyName)
	{
	
		return us.getUserByCompany(companyName);
	}
	
	
	@GetMapping(value="getUserById/{email}")
	public String getUserById(@PathVariable("email") String email) 
	{
		System.out.println(email);
		 return us.getUserById(email);
	}
	
	
	
	


	
	 

}
