package com.ingeneo.cinemas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="client")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2452298370066332027L;

	@Id
	private String identificationNumber;
	
	@Column
	private String name;
	
	@Column
	private String phoneNumber;

}
