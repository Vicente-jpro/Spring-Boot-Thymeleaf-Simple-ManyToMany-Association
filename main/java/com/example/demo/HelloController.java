package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.service.ActorServicedb;
import com.example.demo.service.MovieActorServicedb;
import com.example.demo.service.MovieServicedb;

@Controller
public class HelloController {

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
		return "actor_save";
	}
	
	
	@PostMapping("/movie-actor")
	public String create(@ModelAttribute("movieObject") Movie mv, @ModelAttribute("actorObject") Actor at) {
		
		System.out.println("\n\n");
		System.out.println(""+mv+" \n "+ at);

		System.out.println("\n\n");
		
		this.movieActordb.save( at, mv);
/*	
		Movie movie = new Movie();
		Actor actor = new Actor();
		
		movie.getActors().add( new Actor( (Long) at.getIdActor()) );
		actor.getMovie().add( new Movie( (Long) at.getIdActor() ) );
	
		this.moviedb.create(movie);
	*/	
	
		return "redirect:/";
		
	}
	
	@GetMapping("/movie-actor")
	public String read(Model model) {
		
	//	model.addAttribute("movieActor", );
		
		return "movie_actor_view";
	}
	
	
}
