package com.tiago.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.helpdesk.domain.Chamado;
import com.tiago.helpdesk.domain.dtos.ChamadoDTO;
import com.tiago.helpdesk.services.ChamadoService;

@RequestMapping(value = "/chamados")
@RestController
public class ChamadoResource {

	@Autowired
	private ChamadoService chamadoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
		Chamado obj = chamadoService.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(obj));
	}
	
}
