package com.ingeneo.cinemas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name="movie")
public class Movie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7077487286463335739L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String originalName;
	
	@Column
	private String translatedName;
	
	@Column
	private LocalDateTime releaseDate;
	
	@Lob
    @Column
    private byte[] moviePic;
	
	@Column
	private LocalDateTime finalReleaseDate;
	
	@OneToMany
	private List<MovieGenre> movieGenre;
	
	@Column
	private String synopsis;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
	private Type movieFormat;
	
	@Column
	private int minutesDuration;
	
	@ManyToMany(mappedBy = "movies")
    private Set<CinemaBranch> cinemaBranches;

}
