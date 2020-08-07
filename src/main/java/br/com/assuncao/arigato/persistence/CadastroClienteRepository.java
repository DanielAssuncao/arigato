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
	
	@Query(value = " SELECT distinct c "
		     + " FROM   CadastroCliente c "
           + " WHERE  (LOWER(c.nome) like LOWER(concat('%',:nomeCliente,'%')) "
           + " OR     :nomeCliente is null) "
           + " AND    (c.telefone like concat('%',:telefoneCliente,'%') "
           + " OR     :telefoneCliente is null) "
           + " AND    (c.rg like concat('%',:rgCliente,'%') "
           + " OR     :rgCliente is null) "
           + " AND    (c.cpf like concat('%',:cpfCliente,'%') "
           + " OR     :cpfCliente is null) "
           + " ORDER BY c.nome", 
      countQuery = " SELECT count(s) "
      		   + " FROM   CadastroCliente c "
                 + " WHERE  (LOWER(c.nome) like LOWER(concat('%',:nomeCliente,'%')) "
                 + " OR     :nomeCliente is null) "
                 + " AND    (c.telefone like concat('%',:telefoneCliente,'%') "
                 + " OR     :telefoneCliente is null) "
                 + " AND    (c.rg like concat('%',:rgCliente,'%') "
                 + " OR     :rgCliente is null) "
                 + " AND    (c.cpf like concat('%',:cpfCliente,'%') "
                 + " OR     :cpfCliente is null) "
                 + " ORDER BY c.nome" )
	List<CadastroCliente> getAll(@Param("nomeCliente") String nomeCliente, @Param("telefoneCliente") BigDecimal telefoneCliente, 
								@Param("rgCliente") BigDecimal rgCliente, @Param("cpfCliente") BigDecimal cpfCliente); 
	
	List<CadastroCliente> findAllByOrderByNomeAsc();
	
	@Query(value = "SELECT c from CadastroCliente c WHERE ((c.cpf = :cpf) AND (:id is NULL OR c.id != :id))")
    CadastroCliente getByCpf(@Param("cpf") BigDecimal cpf, @Param("id") BigDecimal id);   
}
