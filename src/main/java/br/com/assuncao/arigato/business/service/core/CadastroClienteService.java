package br.com.assuncao.arigato.business.service.core;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assuncao.arigato.business.service.ICadastroClienteService;
import br.com.assuncao.arigato.entity.CadastroCliente;
import br.com.assuncao.arigato.entity.filter.CadastroClienteFilter;
import br.com.assuncao.arigato.persistence.CadastroClienteRepository;

@Service
public class CadastroClienteService implements ICadastroClienteService{

	@Autowired
	private CadastroClienteRepository repository;

	@Override
	public List<CadastroCliente> findAll(CadastroClienteFilter filter) {
		//TODO
		return null;
	}

	@Override
	@Transactional
	public CadastroCliente save(CadastroCliente entidade) throws Exception {
		//TODO
		return null;
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		//TODO
	}

	@Override
	@Transactional
	public CadastroCliente findOne(BigDecimal id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public BigDecimal getIdFromInstance(CadastroCliente entidade) {
		return entidade.getId();
	}

	@Override
	@Transactional
	public List<CadastroCliente> getAll() {
		//TODO
		return null;
	}
	
	private void validate (CadastroCliente cadCliente) throws Exception {
		//TODO
	}
}
