package com.tiago.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.helpdesk.domain.Tecnico;
import com.tiago.helpdesk.domain.dtos.TecnicoDTO;
import com.tiago.helpdesk.repositories.TecnicoRepository;
import com.tiago.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		/*Qual razão do optional? É feito com optional pois pode achar ou não esse técnico (ID)
		 * no banco.*/
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. ID: " + id)); // Exceção arrow function
	}
	
	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	public Tecnico create(TecnicoDTO obj) {
		return null;
	}
	
}
