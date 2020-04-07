package br.com.assuncao.arigato.persistence;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.assuncao.arigato.entity.CadastroCliente;

@Repository
public interface CadastroClienteRepository extends JpaRepository<CadastroCliente, BigDecimal>{

	List<CadastroCliente> findAllByOrderByNomeAsc();
	
	@Query(value = "SELECT c from CadastroCliente c WHERE ((c.cpf = :cpf) AND (:id is NULL OR c.id != :id))")
    CadastroCliente getByCpf(@Param("cpf") BigDecimal cpf, @Param("id") BigDecimal id);   
}
