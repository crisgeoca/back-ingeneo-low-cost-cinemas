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
@Entity(name="movie_schedule")
public class MovieSchedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4124842182443859783L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@Column
	private LocalDateTime scheduledDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="room_id")
	private Room room;

}
