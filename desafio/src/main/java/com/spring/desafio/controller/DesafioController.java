package com.spring.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.desafio.domain.Desafio;
import com.spring.desafio.services.DesafioService;

@RestController
@CrossOrigin
@RequestMapping("/palavras")
public class DesafioController {

	@Autowired
	private DesafioService service;

	@GetMapping
	public List<Desafio> listar() {
		List<Desafio> obj = service.buscar();
		return obj;
	}

	@PostMapping(value = "/{palavra}")
	public Desafio salvar(@PathVariable String palavra) {
		Desafio obj = new Desafio();
		obj = validarPalavra(palavra);
		if(obj.isPalavraValida()) {
			service.salvar(obj);
		}
		return obj;
	}
	
	public Desafio validarPalavra(String palavra) {
		return service.validaPalavra(palavra);
	}
}
