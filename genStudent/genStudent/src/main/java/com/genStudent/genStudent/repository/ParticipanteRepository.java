package com.genStudent.genStudent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.genStudent.genStudent.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long>  {
	List<Participante> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
