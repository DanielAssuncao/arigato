package br.com.assuncao.arigato.business.service.core;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.assuncao.arigato.business.service.ICadastroCidadeService;
import br.com.assuncao.arigato.entity.CadastroCidade;
import br.com.assuncao.arigato.exceptions.GeneralException;
import br.com.assuncao.arigato.persistence.CadastroCidadeRepository;

@Service
public class CadastroCidadeService implements ICadastroCidadeService{
	
	@Autowired
	private CadastroCidadeRepository repository;

	@Override
	public List<CadastroCidade> findAll(Null filter) {
		return null;
	}

	@Override
	public CadastroCidade save(CadastroCidade entidade) {
		return repository.save(entidade);
	}

	@Override
	public void delete(BigDecimal id) {
		repository.findById(id).orElseThrow(() -> new GeneralException("Objeto não encontrado! Id: " + id + ", Tipo: " + CadastroCidade.class.getName()));
		
		repository.deleteById(id);
	}

	@Override
	public CadastroCidade findOne(BigDecimal id) {
		return null;
	}

	@Override
	public BigDecimal getIdFromInstance(CadastroCidade entidade) {
		return null;
	}

	@Override
	public List<CadastroCidade> getAll() {
		return repository.findAllByOrderByNomeAsc();
	}

	
}
