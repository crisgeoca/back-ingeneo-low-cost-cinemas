package com.ingeneo.cinemas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name="manager")
public class Manager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3851963925599367721L;

	@Id
	private String identificationNumber;
	
	@Column
	private String name;
	
	@Column
	private String phoneNumber;

}
