package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.service.ActorServicedb;
import com.example.demo.service.MovieActorServicedb;
import com.example.demo.service.MovieServicedb;

@Controller
<<<<<<< Updated upstream:main/java/com/example/demo/controllers/HelloController.java
public class HelloController {
=======
public class ActorMovieController {
>>>>>>> Stashed changes:main/java/com/example/demo/controllers/ActorMovieController.java

	@Autowired
	private ActorServicedb actordb;
	
	@Autowired
	private MovieServicedb moviedb;
	
	@Autowired
	private MovieActorServicedb movieActordb;
	
	@RequestMapping("/")
	public String movieActorForm( Model modelActor, Model modelMovie, Model modelMovieObject, Model modelActorObject, Model modelMovieActor) {
		
		
		
		modelActor.addAttribute("listActors", this.actordb.readAll() );
		modelMovie.addAttribute("listMovies", this.moviedb.readAll() );
		modelMovieObject.addAttribute("movieObject", new Movie());
		modelActorObject.addAttribute("actorObject", new Actor());
		return "actor_movie_association_save";
	}
	
	
	@PostMapping("/movie-actor")
	public String create(@ModelAttribute("movieObject") Movie move, @ModelAttribute("actorObject") Actor actor) {
		
		System.out.println("\n\n");

		System.out.println("\n\n");
		
		this.movieActordb.save( actor, move);
/*	
		Movie movie = new Movie();
		Actor actor = new Actor();
		
		movie.getActors().add( new Actor( (Long) at.getIdActor()) );
		actor.getMovie().add( new Movie( (Long) at.getIdActor() ) );
	
		this.moviedb.create(movie);
	*/	
	
		return "redirect:/";
		
	}
	
	@GetMapping("/associate-actor-movie/{id}")
	public String saveMoveActos(@PathVariable("id") Long id , Model modelActor, Model modelMovie, Model modelMovieObject) {
		
		 
		System.out.println("\n\n Entrou no controller \n\n");
		modelActor.addAttribute("actorObject", this.actordb.getActor( new Actor(id) ));
		modelMovieObject.addAttribute("movieObject", new Movie());
		
		modelMovie.addAttribute("listMovies", this.moviedb.readAll() );
		
		return "actor_movie_association_save";
	}
	
	
}
