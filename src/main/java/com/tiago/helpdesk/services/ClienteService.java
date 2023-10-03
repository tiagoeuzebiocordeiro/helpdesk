package com.tiago.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.helpdesk.domain.Cliente;
import com.tiago.helpdesk.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	// FindAll
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
}
