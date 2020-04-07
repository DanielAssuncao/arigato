package br.com.assuncao.arigato.business.service.core;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assuncao.arigato.business.service.ICadastroClienteService;
import br.com.assuncao.arigato.entity.CadastroCliente;
import br.com.assuncao.arigato.entity.filter.CadastroClienteFilter;
import br.com.assuncao.arigato.exceptions.ObjectNotFoundException;
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
		validate(entidade);
		return repository.save(entidade);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		//TODO
	}

	@Override
	@Transactional
	public CadastroCliente findOne(BigDecimal id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CadastroCliente.class.getName()));
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
		if(repository.getByCpf(cadCliente.getCpf(), cadCliente.getId()) != null) {
			throw new Exception("O CPF inserido já está cadastrado no sistema!");
		}
		if(cadCliente.getCpf() == null) {
			throw new Exception("O campo CPF deve ser preenchido!");
		}
		if(cadCliente.getNome() == null) {
			throw new Exception("O campo NOME deve ser preenchido!");
		}
	}
}
