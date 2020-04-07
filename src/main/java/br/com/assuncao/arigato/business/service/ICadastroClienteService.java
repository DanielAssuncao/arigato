package br.com.assuncao.arigato.business.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.assuncao.arigato.entity.CadastroCliente;
import br.com.assuncao.arigato.entity.filter.CadastroClienteFilter;

public interface ICadastroClienteService extends ICrudService<CadastroCliente, BigDecimal, CadastroClienteFilter>{

	List<CadastroCliente> getAll();
}
