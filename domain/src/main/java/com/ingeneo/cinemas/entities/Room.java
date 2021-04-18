package com.ingeneo.cinemas.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
	private Type type;
	
	@Column
	private int rowsNumer;
	
	@Column
	private int maxRowsNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
	private CinemaBranch cinemaBranch;

}
