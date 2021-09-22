package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieServicedb implements MoviceService {

	@Autowired
	private MovieRepository repository;
	private int contador = 0;
	@Override
	public List<Movie> readAll() {
		return this.repository.findAll();
	}
	
	@Async
	public void create(Movie movie) {
		contador++;
		System.out.println("Contador = "+ contador);
		this.repository.save(movie);
		
	}

	
	
}
