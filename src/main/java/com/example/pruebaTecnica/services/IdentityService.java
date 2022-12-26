package com.example.pruebaTecnica.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.pruebaTecnica.components.JwtTokenUtil;
import com.example.pruebaTecnica.entitys.DocumentType;
import com.example.pruebaTecnica.entitys.IndentityEntity;
import com.example.pruebaTecnica.models.IdentityModel;
import com.example.pruebaTecnica.models.ResponseModel;
import com.example.pruebaTecnica.repository.DocumentRepository;

@Component("IndetityService")
public class IdentityService {
	
	@Autowired
	@Qualifier("JwtToken")
	private JwtTokenUtil jwtTokenUtil;
	 
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	public ResponseModel getAllDocuments(String token) throws Exception {
		ResponseModel responseModel;
		try {
			
		boolean isValidToken = jwtTokenUtil.validateToken(token);
		
		if(!isValidToken) {
			throw new Exception("unauthorized");
		}
		
		List<IndentityEntity> documents = documentRepository.findAll();
		
		responseModel = new ResponseModel(HttpStatus.OK, "Success", documents);
		
		//TODO : manejar tipos de excepciones como unauthorized exception
		
		} catch (Exception e) {
			e.printStackTrace(System.out);
			responseModel = new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		
		return responseModel;
	}
	
	public ResponseModel findDocument(String token, String objectId) throws Exception {
		ResponseModel responseModel;
		try {
			
		boolean isValidToken = jwtTokenUtil.validateToken(token);
		
		if(!isValidToken) {
			throw new Exception("unauthorized");
		}
		
		List<IndentityEntity> documents = documentRepository.findByNumber(objectId);
		
		responseModel = new ResponseModel(HttpStatus.OK, "Success", documents);
		
		//TODO : manejar tipos de excepciones como unauthorized exception
		
		} catch (Exception e) {
			e.printStackTrace(System.out);
			responseModel = new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		
		return responseModel;
	}
	
	public ResponseModel upsertDocument(String token, IdentityModel identity, boolean update) throws Exception {
		ResponseModel responseModel;
		try {
			
		boolean isValidToken = jwtTokenUtil.validateToken(token);
		
		if(!isValidToken) {
			throw new Exception("unauthorized");
		}
		
		Date emisionDate = new SimpleDateFormat("dd/MM/yyyy").parse(identity.getEmissionDate());  
		
		IndentityEntity identityObject = new IndentityEntity();
		DocumentType documentType = new DocumentType();
		
		documentType.setCode(identity.getDocumentCode());
		documentType.setName(identity.getDocumentName());
		
		identityObject.setNumber(identity.getNumber());
		identityObject.setExpiryDate(identity.getExpiryDate());
		identityObject.setEmissionDate(emisionDate);
		identityObject.setDocumentType(documentType);
		
		if(update && identity.getObjectId() != null) {
			identityObject.set_id(identity.getObjectId());
		}
		
		documentRepository.save(identityObject);
		
		responseModel = new ResponseModel(HttpStatus.OK, "Success", "");
		
		//TODO : manejar tipos de excepciones como unauthorized exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			responseModel = new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		
		return responseModel;
	}
	
	public ResponseModel deleteDocument(String token, String objectId) throws Exception {
		ResponseModel responseModel;
		try {
			
		boolean isValidToken = jwtTokenUtil.validateToken(token);
		
		if(!isValidToken) {
			throw new Exception("unauthorized");
		}
			
		documentRepository.deleteById(objectId);
		
		responseModel = new ResponseModel(HttpStatus.OK, "Success", "");
		
		//TODO : manejar tipos de excepciones como unauthorized exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			responseModel = new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		
		return responseModel;
	}
	

}
