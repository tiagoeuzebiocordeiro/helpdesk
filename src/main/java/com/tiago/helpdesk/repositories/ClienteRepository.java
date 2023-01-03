package com.tiago.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
