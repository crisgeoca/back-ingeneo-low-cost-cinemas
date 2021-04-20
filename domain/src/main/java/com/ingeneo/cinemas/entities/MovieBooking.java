package com.ingeneo.cinemas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="movie_booking")
public class MovieBooking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1827229793888191222L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="users_identificationNumber")
	private Users user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cinema_branch_id")
	private CinemaBranch cinemaBranch;
	
	@Column
	private int chairsNumber;
	
	@Column
	private LocalDateTime bookingDate;
	
	@Column
	private LocalDateTime expirationBookingDate;
	
	@Column
	private boolean bookingState;

}
