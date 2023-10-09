package com.tiago.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiago.helpdesk.domain.Cliente;
import com.tiago.helpdesk.domain.Pessoa;
import com.tiago.helpdesk.domain.dtos.ClienteDTO;
import com.tiago.helpdesk.repositories.ClienteRepository;
import com.tiago.helpdesk.repositories.PessoaRepository;
import com.tiago.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.tiago.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha())); // pegar a senha e encodar
		validarPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return clienteRepository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validarPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}

	public void delete(Integer id) {
		
		Cliente obj = findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("O cliente possui chamados registrados e não pode ser deletado!");
		}
		
		clienteRepository.deleteById(id);
		
	}

	private void validarPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
