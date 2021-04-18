package com.ingeneo.cinemas.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@Entity(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String originalName;
	
	@Column
	private String translatedName;
	
	@Column
	private Date releaseDate;
	
	@Lob
    @Column
    private byte[] moviePic;
	
	@Column
	private Date finalReleaseDate;
	
	@OneToMany(mappedBy = "movie")
	private List<MovieGenre> movieGenre = new ArrayList<MovieGenre>();
	
	@Column
	private String synopsis;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
	private Type movieFormat;
	
	@Column
	private int minutesDuration;
	
	@ManyToMany(mappedBy = "movies")
    private Set<CinemaBranch> cinemaBranches = new HashSet<>();

}
