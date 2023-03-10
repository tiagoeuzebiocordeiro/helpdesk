package com.tiago.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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

/*Classe de serviço de banco de dados*/
@Service
public class DBService {

/*Injeção de dependências dos repositories*/
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "760.457.770-93", "valdir@gmail.com", "password123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Nikola Tesla", "769.698.580-90", "niktesla@gmail.com", "electros");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Sem conexão", "2 horas sem Internet", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		
	}
	
}
