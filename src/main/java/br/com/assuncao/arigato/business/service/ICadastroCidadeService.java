package br.com.assuncao.arigato.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;

import br.com.assuncao.arigato.entity.CadastroCidade;

public interface ICadastroCidadeService extends ICrudService<CadastroCidade, BigDecimal, Null>{
	
	List<CadastroCidade> getAll();

}
