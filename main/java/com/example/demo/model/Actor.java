package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size ;

@Entity
@Table( name = "actors")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_actor")
	private Long idActor;
	
	@Size( max = 50)
	@Column(name="nome_actor")
	private String nomeActor;

	@ManyToMany(mappedBy = "actors")
	private List<Movie> movie = new ArrayList<Movie>();

	public Actor() {
		
		
	}
	public Actor(Long idActor) {
		this.idActor = idActor;
	}
	
	public Actor(Long idActor, String nomeAutor) {
		super();
		this.idActor = idActor;
		this.nomeActor = nomeAutor;
		
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

	public String getNomeActor() {
		return nomeActor;
	}

	public void setNomeActor(String nomeActor) {
		this.nomeActor = nomeActor;
	}

	
	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", nomeActor=" + nomeActor + "]";
	}

	

	
	
	
	
}
