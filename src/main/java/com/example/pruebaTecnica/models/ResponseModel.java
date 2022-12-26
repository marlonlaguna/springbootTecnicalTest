package com.example.pruebaTecnica.models;

import org.springframework.http.HttpStatus;

public class ResponseModel {
	
	private HttpStatus status;
	private String message;
	private Object data;
	
	
	public ResponseModel(HttpStatus status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
