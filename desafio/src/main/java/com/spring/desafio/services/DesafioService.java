package com.spring.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.desafio.domain.Desafio;
import com.spring.desafio.repositores.DesafioRepository;

@Service
public class DesafioService {
	
	@Autowired
	private DesafioRepository repository;
	
	public List<Desafio> buscar() {
		List<Desafio> obj = repository.findAll();
		return obj;
	}
	
	public Desafio salvar(Desafio obj) {
		return repository.save(obj);
	}
}
