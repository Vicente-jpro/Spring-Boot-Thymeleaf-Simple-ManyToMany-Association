package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;

@Repository
public class MovieActorServicedb {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Actor actor, Movie movie) {
		
		entityManager.createNativeQuery("INSERT INTO public.movie_actor(\n"
				+ "	actor_id, movie_id)\n"
				+ "	VALUES ("+actor.getIdActor()+", "+movie.getIdMovie()+");\n"
				+ "	")
		.executeUpdate();
		//+movie.getIdMovie()+
	}
	
	@Transactional
	public List<Object[]> readAssociation() {
		String sql = "SELECT actors.name, movie.title\n"
				+ "	FROM movie_actor\n"
				+ "	INNER JOIN movies\n"
				+ "	ON movies.id_movie = movie_actor.movie_id\n"
				+ "	INNER JOIN actors\n"
				+ "	ON actors.id_actor = movie_actor.actor_id";
		
	List<Object[]> list = entityManager.createNativeQuery( sql )
		.getResultList();
	
		return list;
	}

	
}
