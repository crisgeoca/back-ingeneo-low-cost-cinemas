package com.ingeneo.cinemas.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="movie_booking")
public class MovieBooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Client.class)
	@JoinColumn(name="client_id")
	private Client client;
	
	@Column
	private int chairsNumber;
	
	@Column
	private Date bookingDate;
	
	@Column
	private boolean paid;

}
