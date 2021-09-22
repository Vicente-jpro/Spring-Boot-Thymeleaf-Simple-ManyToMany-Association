package com.example.demo.service;

import java.util.List;

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
}
