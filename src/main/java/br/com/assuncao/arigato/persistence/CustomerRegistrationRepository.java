package br.com.assuncao.arigato.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.assuncao.arigato.entity.CustomerRegistration;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Long>{
	
	@Query(value = " SELECT distinct c "
		     + " FROM   CustomerRegistration c "
           + " WHERE  (LOWER(c.name) like LOWER(concat('%',:customerName,'%')) "
           + " OR     :customerName is null) "
           + " AND    (c.phoneNumber like concat('%',:customerPhoneNumber,'%') "
           + " OR     :customerPhoneNumber is null) "
           + " AND    (c.rg like concat('%',:customerRg,'%') "
           + " OR     :customerRg is null) "
           + " AND    (c.cpf like concat('%',:customerCpf,'%') "
           + " OR     :customerCpf is null) "
           + " ORDER BY c.name", 
      countQuery = " SELECT count(s) "
      		   + " FROM   CustomerRegistration c "
                 + " WHERE  (LOWER(c.name) like LOWER(concat('%',:customerName,'%')) "
                 + " OR     :customerName is null) "
                 + " AND    (c.phoneNumber like concat('%',:customerPhoneNumber,'%') "
                 + " OR     :customerPhoneNumber is null) "
                 + " AND    (c.rg like concat('%',:customerRg,'%') "
                 + " OR     :customerRg is null) "
                 + " AND    (c.cpf like concat('%',:customerCpf,'%') "
                 + " OR     :customerCpf is null) "
                 + " ORDER BY c.name" )
	List<CustomerRegistration> getAll(@Param("customerName") String customerName, @Param("customerPhoneNumber") Long customerPhoneNumber, 
								@Param("customerRg") Long customerRg, @Param("customerCpf") Long customerCpf); 
	
	List<CustomerRegistration> findAllByOrderByNameAsc();
	
	@Query(value = "SELECT c from CustomerRegistration c WHERE ((c.cpf = :cpf) AND (:id is NULL OR c.id != :id))")
    CustomerRegistration getByCpf(@Param("cpf") Long cpf, @Param("id") Long id);   
}
