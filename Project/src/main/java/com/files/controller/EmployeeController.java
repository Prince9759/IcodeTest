package com.files.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.files.Service.EmployeeService;
import com.files.entity.employee;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	
	@PostMapping(value="add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployee(@RequestBody employee emp) 
	{
		return es.storeEmployee(emp);
		}
	
	@PatchMapping(value="upadate",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String UpdateEmployee(@RequestBody employee emp) 
	{
		return es.UpdateEmployee(emp);
	}
	
	@GetMapping(value = "findAllEmp")
	public List<employee> getAllEmployee()
	{
		return es.getAllEmployee();
	}
	
	@GetMapping(value="findEmployeeById/{email}")
	public String findEmployeeById(@PathVariable("email") String email) 
	{
		return es.findEmployeeById(email);
	}
	
	@DeleteMapping(value="deleteEmployee/{email}")
	public String deleteEmployeeById(@PathVariable("email") String email) 
	{
		return es.deleteEmployee(email);
	}
	
	@GetMapping(value="getEmployeeByCompanyName/{companyName}")
	public int getEmployeeByCompany(@PathVariable("companyName") String companyName)
	{
	
		return es.getEmployeeByCompany(companyName);
	}
	
	

}
