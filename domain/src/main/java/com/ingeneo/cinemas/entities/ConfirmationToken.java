package com.ingeneo.cinemas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity(name="confirmation_token")
public class ConfirmationToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 67049182689363034L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	
	@Column
	private String token;
	
	@Column
	private LocalDateTime createdAt;
	
	@Column
	private LocalDateTime expiresAt;
	
	@Column
	private LocalDateTime confirmedAt;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "users_identificationNumber")
	private Users users;

}
