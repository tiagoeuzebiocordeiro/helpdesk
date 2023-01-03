package com.tiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
