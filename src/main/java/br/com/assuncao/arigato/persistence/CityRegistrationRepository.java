package br.com.assuncao.arigato.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.assuncao.arigato.entity.CityRegistration;

@Repository
public interface CityRegistrationRepository extends JpaRepository<CityRegistration, Long>{
	
	List<CityRegistration> findAllByOrderByNameAsc();
}
