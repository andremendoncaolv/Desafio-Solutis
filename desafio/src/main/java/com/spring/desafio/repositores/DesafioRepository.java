package com.spring.desafio.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.desafio.domain.Desafio;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Integer>{

}
