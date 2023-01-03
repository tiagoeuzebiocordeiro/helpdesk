package com.tiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
