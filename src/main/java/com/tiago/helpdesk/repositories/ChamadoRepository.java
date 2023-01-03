package com.tiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
