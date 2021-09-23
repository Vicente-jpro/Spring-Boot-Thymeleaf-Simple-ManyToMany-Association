package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;


@Service
public class ActorServicedb implements ActorService{
	
	@Autowired
	private ActorRepository repository;

	@Override
	public List<Actor> readAll() {
		
		return this.repository.findAll();
	}

	@Override
	public void create(Actor actor) {
		
		this.repository.save(actor);
		
	}

	@Override
	public Actor getActor(Actor actor) {
		
		try {
			
			Optional<Actor> at  =this.repository.findById( actor.getIdActor() ); 
			actor = at.get();
		} catch (Exception e) {
			System.err.println("Erro on fetch the id: "+e);
		}
		
		return  actor;
	}

	@Override
	public void delete(Actor actor) {
		try {

			this.repository.deleteById( actor.getIdActor() );
		} catch (Exception e) {
			System.out.println("Impossible to delete this actor: "+e);
		}
	}
}
