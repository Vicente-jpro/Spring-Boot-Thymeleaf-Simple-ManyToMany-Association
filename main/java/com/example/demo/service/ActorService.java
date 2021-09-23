package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Actor;

public interface ActorService {
	List<Actor> readAll();
	void create(Actor actor);
	Actor getActor(Actor actor);
	void delete(Actor actor);
}
