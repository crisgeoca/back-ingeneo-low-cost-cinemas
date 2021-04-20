package com.ingeneo.cinemas.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="room")
public class Room implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 636887196703805931L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "room_type_id")
	private Type type;
	
	@Column
	private int rowsNumber;
	
	@Column
	private int maxChairsNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cinema_branch_id")
	private CinemaBranch cinemaBranch;

}
