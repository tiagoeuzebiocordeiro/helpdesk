package com.tiago.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.helpdesk.domain.Tecnico;
import com.tiago.helpdesk.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		/*Qual razão do optional? É feito com optional pois pode achar ou não esse técnico (ID)
		 * no banco.*/
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElse(null); // Se não encontrar o objeto, retorna null [FUTURAMENTE TERÁ EXCEÇÃO]
	}
	
}
