package com.ingeneo.cinemas.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="cinema_branch")
public class CinemaBranch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6281500757115781017L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaBranch")	
	private City city;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id", referencedColumnName = "identificationNumber")
	private Manager manager;

	@OneToMany(mappedBy = "cinemaBranch")
	private List<Room> room;

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "branches_movies",
			joinColumns = @JoinColumn(name = "cinemaBranch_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movies;

}
