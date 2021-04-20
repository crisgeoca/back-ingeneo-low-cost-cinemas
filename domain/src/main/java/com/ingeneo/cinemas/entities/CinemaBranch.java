package com.ingeneo.cinemas.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	@JoinColumn(nullable = false, name = "city_id")
	private City city;

	@ManyToOne
	@JoinColumn(nullable = false, name = "users_identificationNumber")
	private Users users;

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "branches_movies",
			joinColumns = @JoinColumn(name = "cinemaBranch_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movies;

}
