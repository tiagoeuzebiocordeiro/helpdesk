package com.tiago.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiago.helpdesk.domain.Chamado;
import com.tiago.helpdesk.domain.Cliente;
import com.tiago.helpdesk.domain.Tecnico;
import com.tiago.helpdesk.domain.enums.Perfil;
import com.tiago.helpdesk.domain.enums.Prioridade;
import com.tiago.helpdesk.domain.enums.Status;
import com.tiago.helpdesk.repositories.ChamadoRepository;
import com.tiago.helpdesk.repositories.ClienteRepository;
import com.tiago.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDb() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "687.898.210-33", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Nikola Tesla", "650.621.960-27", "tesla@mail.com", encoder.encode("eletric"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
	
}
