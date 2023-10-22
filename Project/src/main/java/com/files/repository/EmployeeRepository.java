package com.files.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.files.entity.User;
import com.files.entity.employee;

public interface EmployeeRepository  extends MongoRepository<employee, String>{
	@Query("{companyName : ?0}")                                         // SQL Equivalent : SELECT * FROM BOOK where author = ?
    List<employee> getemployeeByCompanyName(String companyName);
}
