package br.com.assuncao.arigato.business.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.assuncao.arigato.entity.CadastroCliente;
import br.com.assuncao.arigato.entity.filter.CadastroClienteFilter;

public interface ICadastroClienteService {

	List<CadastroCliente> findAll(CadastroClienteFilter filter);
	
	CadastroCliente save(CadastroCliente t) throws Exception;
	
	void delete(BigDecimal i);
	
	CadastroCliente findOne(BigDecimal i);
	
	BigDecimal getIdFromInstance(CadastroCliente t);
	
	List<CadastroCliente> getAll();
}
