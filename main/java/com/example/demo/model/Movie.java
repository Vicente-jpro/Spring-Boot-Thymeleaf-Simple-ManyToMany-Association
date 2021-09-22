package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table( name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_movie")
	private Long idMovie;
	
	@Size( max = 50)
	private String title;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable( name = "movie_actor", 
	joinColumns={@JoinColumn( name = "movie_id")},
	inverseJoinColumns = {@JoinColumn( name = "actor_id")})
	private List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
		
	}
	
	public Movie (Long idMovie) {
		this.idMovie = this.idMovie;
	}
	
	
	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", title=" + title + "";

	}
	
	
	
	
}
