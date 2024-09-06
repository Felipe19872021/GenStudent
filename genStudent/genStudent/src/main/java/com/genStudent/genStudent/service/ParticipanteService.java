package com.genStudent.genStudent.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.genStudent.genStudent.model.Participante;
import com.genStudent.genStudent.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;
	
	public Participante salvar (Participante participante) {
		
		participante.setMediaFinal(calcMedia(participante.getPriSemestre(), participante.getSegSemestre()));
		return repository.save(participante);
		
	}
	
	public Participante getById (long id) {
		Optional<Participante> participante = repository.findById(id);
		
		if(participante.isEmpty())
			throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, "Participante nao encontrado");
		
		return participante.get();
	}
	
	public double calcMedia (double pri, double seg) {
		
		double media = (pri + seg) /2;
		return media;
	}
	
	
	
}
