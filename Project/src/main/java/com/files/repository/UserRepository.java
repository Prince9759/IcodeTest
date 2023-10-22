package com.files.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.files.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	@Query("{companyName : ?0}")                                         // SQL Equivalent : SELECT * FROM BOOK where author = ?
    List<User> getYserByCompanyName(String companyName);

}
