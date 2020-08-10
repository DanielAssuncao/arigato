package br.com.assuncao.arigato.presentation.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.assuncao.arigato.business.service.ICadastroCidadeService;
import br.com.assuncao.arigato.business.service.ICadastroClienteService;
import br.com.assuncao.arigato.entity.CadastroCidade;
import br.com.assuncao.arigato.entity.CadastroCliente;
import br.com.assuncao.arigato.entity.filter.CadastroClienteFilter;

@RestController
@RequestMapping(value="/cadastro-cliente")
public class CadastroClienteController extends CrudBaseController<CadastroCliente, BigDecimal, CadastroClienteFilter, ICadastroClienteService>{
	
	protected static final String CONTEXTO = "/cadastro-cliente.do";
	
	private ICadastroCidadeService cadastroCidadeService;
	
	@Autowired
	public CadastroClienteController(ICadastroClienteService service, ICadastroCidadeService cadastroCidadeService) {
		super(CONTEXTO, service);
		this.cadastroCidadeService = cadastroCidadeService;
	}
	
	
	@RequestMapping(value = "/buscarCadCidades", method=RequestMethod.GET)
	protected List<CadastroCidade> buscarCadastroCidades() { 
		List<CadastroCidade> listaCidades = new ArrayList<>();
	
	try {
		listaCidades = cadastroCidadeService.getAll();
	} catch (Exception e) {
		 e.getMessage();
	}
	
	return listaCidades;
	}
	
	/**
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public ResponseEntity<?> save() {
	
	CadastroEndereco cadEndereco = new CadastroEndereco();
	cadEndereco.setId(null);
	cadEndereco.setLogradouro("Rua Italia");
	cadEndereco.setNumero(BigDecimal.valueOf(60));
	cadEndereco.setBairro("Centro");
	cadEndereco.setCep(BigDecimal.valueOf(14800123));
	
	CadastroCliente cadCliente = new CadastroCliente();
	cadCliente.setId(null);
	cadCliente.setNome("Daniel Gomes");
	cadCliente.setCpf(BigDecimal.valueOf(1234));
	cadCliente.setRg(BigDecimal.valueOf(5678));
	cadCliente.setDataNascimento(LocalDateTime.of(1987, 06, 30, 0, 0));
	cadCliente.setDataCadastro(LocalDateTime.now());
	cadCliente.setDdd(BigDecimal.valueOf(016));
	cadCliente.setTelefone(BigDecimal.valueOf(123456789));
	cadCliente.setCadEndereco(cadEndereco);
	
	CadastroCliente salvo = new CadastroCliente();
	
	try {	
		salvo = service.save(cadCliente);
	} catch (Exception e) {
		 e.getMessage();
	}
	
	return ResponseEntity.ok().body(salvo);
	}**/
}

