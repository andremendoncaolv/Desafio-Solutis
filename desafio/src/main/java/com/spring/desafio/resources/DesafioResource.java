package com.spring.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.desafio.domain.Desafio;
import com.spring.desafio.services.DesafioService;

@Configuration
@EnableWebMvc
//@RestController
@RestController
@CrossOrigin("*")
@RequestMapping("/palavras")
public class DesafioResource extends WebMvcConfigurerAdapter{
//public class DesafioResource{
	private char[] vogais = {'A','E','I','O','U'};
	
	
	  @Override public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE",
	  "OPTIONS", "HEAD", "TRACE", "CONNECT"); }
	 
	@Autowired
	private DesafioService service;
	
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	//public ResponseEntity<?> listar() {
	public List<Desafio> listar() {
		List<Desafio> obj = service.buscar();
		//return ResponseEntity.ok().body(obj);
		return obj;
		 
	}
	
	
	@PostMapping(value="/{palavra}")	
	public Desafio validarPalavra(@PathVariable String palavra) {
		
		long start = System.currentTimeMillis();
		double tempoTotal;
		int count = 0;
		char vogal;
		boolean isVogal = false;
		
		Desafio obj = new Desafio();
		
		for(int pos = 0;pos < palavra.length();pos++){

            for(int j = 0;j < vogais.length;j++){

            	//Valída se é vogal
                if(palavra.toUpperCase().charAt(pos) == vogais[j]){ 
                	vogal = vogais[j];
                	
                	//Valída se o antecessor é consoante
                	if(pos > 0 && pos >1) {
	                	if(palavra.toUpperCase().charAt(pos - 1) != vogais[j]) { 
	                		
	                		char c = palavra.toUpperCase().charAt(pos - 2);
	                		
	                		//Valída se o antecessor do antecessor é vogal
	                		for (char ch : vogais) {
									if(ch == c) {
										isVogal = true;
										//vogal = c;
									}
							}
	                		if(isVogal) {
		                		
		                		for(int x = 0; x < palavra.length();x++) {
		                				if(palavra.toUpperCase().charAt(x) == vogais[j]){
		                					count++;
		                				}
		                		}
		                		//Valida se a vogal é econtrada mais de uma vez na String
		                		if(count == 1) {
		                			//numeroVogais++;	
		                			
		                			obj.setPalavra(palavra);
		                			obj.setVogal(vogal);
		                			
		                			tempoTotal = Long.MAX_VALUE;
		                			tempoTotal = tempoTotal * 1000; 
		                			tempoTotal = Math.ceil(System.currentTimeMillis() - start);
		                			obj.setTempoTotal(tempoTotal);
		                			
		                			obj = service.salvar(obj);
		                			
		                			//return ResponseEntity.ok().body(obj);
		                			return obj;
		                		}
	                		}
	                	}
                	}
                }
            }
        }
        	//return ResponseEntity.ok().body(obj);
			return obj;
		}
}
