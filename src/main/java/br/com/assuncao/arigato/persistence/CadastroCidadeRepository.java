package br.com.assuncao.arigato.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.assuncao.arigato.entity.CadastroCidade;

@Repository
public interface CadastroCidadeRepository extends JpaRepository<CadastroCidade, BigDecimal>{
	
	List<CadastroCidade> findAllByOrderByNomeAsc();
}
