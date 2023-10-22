package com.files.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.files.entity.User;
import com.files.entity.employee;
import com.files.repository.EmployeeRepository;
import com.files.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private EmployeeRepository er;
	public String signIn(User user  ) 
	{
		Optional<User> result = repo.findById(user.getEmail());
		
		if(result.isPresent()) 
		{
			 User u = result.get();
			
			 if(u.getPassword().equals(user.getPassword())) 
			 {
				if(user.getTypesOfRole().equals(u.getTypesOfRole()) && user.getTypesOfRole().equals("admin")) 
				{
					return "Admin Successfully Login";
				}
				else if(user.getTypesOfRole().equals(u.getTypesOfRole()) && user.getTypesOfRole().equals("user"))
				{
					return "User LoginSuccessfully";
				}
				else 
				{
					return "Invalid details";
				}
			 }
			 else 
			 {
				 return "Invlalid Password";
			 }
		}
		else 
		{
		    return "Invalid EmailId";	
		}
	}
	
	public String signUp(User user) 
	{
	      if(user.getTypesOfRole().equals("user")) 
	      {
	    	  return "user can not register Company Contact to admin";
	      }
	      else 
	      {
	    	   Optional<User> findById = repo.findById(user.getEmail());
	    	   if(findById.isPresent()) 
	    	   {
	    		   return "Already Present";
	    	   }
	    	   else 
	    	   {
	    		   repo.save(user);
	    		   return "Add Successfully";
	    	   }
	      }
			
		}
	
	public String signInEmp(employee emp  ) 
	{
		Optional<employee> result = er.findById(emp.getEmail());
		
		if(result.isPresent()) 
		{
			 employee u = result.get();
			
			 if(u.getPassword().equals(emp.getPassword())) 
			 {
				if(emp.getTypesOfRole().equals(u.getTypesOfRole()) && emp.getTypesOfRole().equals("admin")) 
				{
					return "Admin Successfully Login";
				}
				else if(emp.getTypesOfRole().equals(u.getTypesOfRole()) && emp.getTypesOfRole().equals("user"))
				{
					return "User LoginSuccessfully";
				}
				else 
				{
					return "Invalid details";
				}
			 }
			 else 
			 {
				 return "Invlalid Password";
			 }
		}
		else 
		{
		    return "Invalid EmailId";	
		}
	}
	
	public int getUserByCompany(String companyName)
	{
		 List<User> yserByCompanyName = repo.getYserByCompanyName(companyName);
		 return  yserByCompanyName.size();
	}
	
	
	public String getUserById(String email)
	{
		 Optional<User> findById = repo.findById(email);
		  User user = findById.get();
		  return user.getCompanyName();
	}
	


	}





