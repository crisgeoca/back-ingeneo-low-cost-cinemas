package com.ingeneo.cinemas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="movie_genre")
public class MovieGenre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3792961148712870676L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieGenre")
	private Movie movie;

}
