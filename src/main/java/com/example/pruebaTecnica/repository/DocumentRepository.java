package com.example.pruebaTecnica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.pruebaTecnica.entitys.IndentityEntity;

public interface DocumentRepository extends MongoRepository<IndentityEntity, String>{
	
	@Query("{'_id' : ?0}")
	List<IndentityEntity> findByNumber(String number);
	

}
