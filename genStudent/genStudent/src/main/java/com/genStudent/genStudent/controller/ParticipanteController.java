package com.genStudent.genStudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genStudent.genStudent.model.Participante;
import com.genStudent.genStudent.repository.ParticipanteRepository;
import com.genStudent.genStudent.service.ParticipanteService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/participantes")
public class ParticipanteController {
	
	@Autowired
	private ParticipanteRepository repository;
	
	@Autowired
	private ParticipanteService service;
	
	/*
	 * GET
	 * **/
	@GetMapping()
	public ResponseEntity<List<Participante>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	/*
	 * GET Pelo id
	 * **/
	@GetMapping("/{id}")
	public ResponseEntity<Participante> getById(@PathVariable long id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	/*
	 * GET Pelo nome
	 * **/
	
	@GetMapping("/por-nome/{nome}")
	public ResponseEntity<List<Participante>> getAllByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	/*
	 * POST
	 * **/
	
	@PostMapping
	public ResponseEntity<Participante> post (@RequestBody Participante participante) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.salvar(participante));
		
	}

	/*
	 * PUT
	 * **/
	
	@PutMapping
	public ResponseEntity<Participante> put (@RequestBody Participante participante) {
		
		//Se o usuario nao existir o service retornará um erro 400 (BadRequest)
		service.getById(participante.getId());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(service.salvar(participante));
		
	}
	
	/*
	 * Delete
	 * **/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		//Se o usuario nao existir o service retornará um erro 400 (BadRequest)
		service.getById(id);
		
		repository.deleteById(id);
		
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
	
	
}
