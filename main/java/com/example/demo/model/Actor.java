package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size ;

@Entity
@Table( name = "actors")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy("id_actor")
	@Column(name="id_actor")
	private Long idActor;
	
	@Size( max = 50)
	private String name;
	
	@Size(max = 50)
	private String email;

	@ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Movie> movie = new ArrayList<Movie>();

	public Actor() {
		
		
	}
	public Actor(Long idActor) {
		this.idActor = idActor;
	}
	

	
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	public Long getIdActor() {
		return idActor;
	}

	public void setIdActor(Long idActor) {
		this.idActor = idActor;
	}

	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", name=" + name + ", email=" + email + ", movie=" + movie + "]";
	}
	
	

	

	
	
	
	
}
