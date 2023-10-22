package com.files.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.files.entity.User;
import com.files.entity.employee;
import com.files.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	
	@Autowired
	EmployeeRepository repo;
	
	public String storeEmployee(employee emp) 
	{
		
		repo.save(emp);
		return "Add Employee Successfully";
	}
	
	
	public List<employee> getAllEmployee()
	{
		return  repo.findAll();
	}
	
	public String findEmployeeById(String email)
	{
		         Optional<employee> findById = repo.findById(email);
		         if(findById.isPresent()) 
		         {
		        	 employee e = findById.get();
		        	 return e.getCompanyName();
		         }
		         else 
		         {
		        	 return "Employee not Present";
		         }
	}
  
	public String deleteEmployee(String email) 
	{
		   Optional<employee> findById = repo.findById(email);
		   if(findById.isPresent()) 
	         {
	        	 employee e = findById.get();
	        	  repo.deleteById(email);
	        	  return "Employee delete Successfully";
	         }
	         else 
	         {
	        	 return "Employee not Present";
	         }
		
	}
	public String UpdateEmployee(employee emp) 
	{
		   Optional<employee> findById = repo.findById(emp.getEmail());
		   if(findById.isPresent()) 
	         {
	        	 employee e = findById.get();
	        	 e.setEmail(emp.getEmail());
	        	 e.setFirstName(emp.getFirstName());
	        	 e.setLastName(emp.getLastName());
	        	 e.setPassword(emp.getPassword());
	        	 e.setTypesOfRole(emp.getTypesOfRole());
	        	 
	        	  repo.save(e);
	        	  return "Employee update Successfully";
	         }
	         else 
	         {
	        	 return "Employee not Present";
	         }
		
	}
	
	
	public int getEmployeeByCompany(String companyName)
	{
		 List<employee> employeeByCompanyName = repo.getemployeeByCompanyName(companyName);
		 return  employeeByCompanyName.size();
	}
}
