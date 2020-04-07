package br.com.assuncao.arigato.presentation.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.assuncao.arigato.business.service.core.CadastroClienteService;
import br.com.assuncao.arigato.entity.CadastroCliente;

@RestController
@RequestMapping(value="/cadastro-clientes")
public class CadastroClienteController {
	
	@Autowired
	private CadastroClienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Controller de cadastro de clientes funcionando!";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable BigDecimal id) {
		CadastroCliente cadastroCliente = service.findOne(BigDecimal.valueOf(1));
		return ResponseEntity.ok().body(cadastroCliente);
	}
}

