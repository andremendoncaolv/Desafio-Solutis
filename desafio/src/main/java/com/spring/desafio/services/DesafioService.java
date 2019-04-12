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
	
	public Desafio validaPalavra(String palavra) {
		char[] vogais = { 'A', 'E', 'I', 'O', 'U' };
		
		long start = System.currentTimeMillis();
		double tempoTotal;
		char vogal;
		boolean isVogal = false;

		Desafio obj = new Desafio();

		for (int pos = 0; pos < palavra.length(); pos++) {
			int count = 0;

			for (int j = 0; j < vogais.length; j++) {

				// Valída se é vogal
				if (palavra.toUpperCase().charAt(pos) == vogais[j]) {
					vogal = vogais[j];

					// Valída se o antecessor é consoante
					if (pos > 0 && pos > 1) {
						if (palavra.toUpperCase().charAt(pos - 1) != vogais[j]) {

							char c = palavra.toUpperCase().charAt(pos - 2);

							// Valída se o antecessor do antecessor é vogal
							for (char ch : vogais) {
								if (ch == c) {
									isVogal = true;
								}
							}
							if (isVogal) {

								for (int x = 0; x < palavra.length(); x++) {
									if (palavra.toUpperCase().charAt(x) == vogais[j]) {
										count++;
									}
								}
								// Valida se a vogal é econtrada mais de uma vez na String
								if (count == 1) {
									obj.setPalavra(palavra);
									obj.setVogal(vogal);

									tempoTotal = Long.MAX_VALUE;
									tempoTotal = tempoTotal * 1000;
									tempoTotal = Math.ceil(System.currentTimeMillis() - start);
									obj.setTempoTotal(tempoTotal);
									obj.setPalavraValida(true);
									return obj;
								}
							}
						}
					}
				}
			}
		}
		return obj;
	}
}
