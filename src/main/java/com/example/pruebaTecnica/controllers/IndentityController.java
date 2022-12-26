package com.example.pruebaTecnica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaTecnica.components.JwtTokenUtil;
import com.example.pruebaTecnica.models.IdentityModel;
import com.example.pruebaTecnica.models.ResponseModel;
import com.example.pruebaTecnica.services.IdentityService;

@RestController
public class IndentityController {
	
	 @Autowired
	 @Qualifier("JwtToken")
	  private JwtTokenUtil jwtTokenUtil;
	 
	 @Autowired
	 @Qualifier("IndetityService")
	  private IdentityService identityService;

	
	@GetMapping("/generateToken")
	public ResponseEntity<String> generateToken(){	
		
		String token = jwtTokenUtil.generateToken();
		
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}
	
	@GetMapping("/getAllDocuments")
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<ResponseModel> getAll(@RequestHeader("token") String token) throws Exception{	
		ResponseModel response = identityService.getAllDocuments(token);
		return new ResponseEntity<ResponseModel>(response, response.getStatus());
	}
	
	@GetMapping("/findDocument")
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<ResponseModel> findOne(@RequestHeader("token") String token, @RequestParam(name = "id") String objectId) throws Exception{	
		ResponseModel response = identityService.findDocument(token,objectId);
		return new ResponseEntity<ResponseModel>(response, response.getStatus());
	}
	
	@PostMapping("/newDocument")
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<ResponseModel> insertDocument(@RequestHeader("token") String token, @RequestBody IdentityModel identity) throws Exception{	
		ResponseModel response = identityService.upsertDocument(token, identity, false);
		return new ResponseEntity<ResponseModel>(response, response.getStatus());
	}

	@PutMapping("/updateDocument")
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<ResponseModel> updateDocument(@RequestHeader("token") String token, @RequestBody IdentityModel identity) throws Exception{	
		ResponseModel response = identityService.upsertDocument(token, identity,true);
		return new ResponseEntity<ResponseModel>(response, response.getStatus());
	}
	
	@DeleteMapping("/deleteDocument")
	@CrossOrigin(origins = "http://localhost:9090")
	public ResponseEntity<ResponseModel> delete(@RequestHeader("token") String token, @RequestParam(name = "id") String objectId) throws Exception{	
		ResponseModel response = identityService.deleteDocument(token, objectId);
		return new ResponseEntity<ResponseModel>(response, response.getStatus());
	}


}
