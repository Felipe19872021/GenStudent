package com.genStudent.genStudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_participante")
public class Participante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Insira um nome para o cadastro!!!")
	private String nome;
	
	@Min(value = 5, message =  "O participante não pode ser menor do que 5 anos de idade!")
	@Max(value = 99, message =  "O participante não pode ser maior de 99 anos de idade")
	private int idade;
	
	@Min(value = 0, message =  "Não é permitido valores menor do que zero")
	@Max(value = 10, message =  "Não é permitdo valores maior do que dez")
	private double priSemestre;
	
	@Min(value = 0, message =  "Não é permitido valores menor do que zero")
	@Max(value = 10, message =  "Não é permitdo valores maior do que dez")
	private double segSemestre;
	
	private double mediaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPriSemestre() {
		return priSemestre;
	}

	public void setPriSemestre(double priSemestre) {
		this.priSemestre = priSemestre;
	}

	public double getSegSemestre() {
		return segSemestre;
	}

	public void setSegSemestre(double segSemestre) {
		this.segSemestre = segSemestre;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
}
