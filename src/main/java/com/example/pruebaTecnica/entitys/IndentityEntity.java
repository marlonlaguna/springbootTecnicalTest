package com.example.pruebaTecnica.entitys;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "identityDocument")
public class IndentityEntity {
	
	@Id
	private String _id;
	
	private String number;
	
	private String expiryDate;
	private Date emissionDate;
	
	private DocumentType documentType;
	
	public IndentityEntity(String number, String expiryDate, Date emissionDate, DocumentType documentType) {
		super();
		this.number = number;
		this.expiryDate = expiryDate;
		this.emissionDate = emissionDate;
		this.documentType = documentType;
	}
	
	
	
	public IndentityEntity() {
	}



	public DocumentType getDocumentType() {
		return documentType;
	}



	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}



	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
