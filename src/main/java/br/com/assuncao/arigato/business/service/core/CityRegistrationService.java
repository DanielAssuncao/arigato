package br.com.assuncao.arigato.business.service.core;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.assuncao.arigato.business.service.ICityRegistrationService;
import br.com.assuncao.arigato.entity.CityRegistration;
import br.com.assuncao.arigato.exceptions.GeneralException;
import br.com.assuncao.arigato.persistence.CityRegistrationRepository;

@Service
public class CityRegistrationService implements ICityRegistrationService{
	
	@Autowired
	private CityRegistrationRepository repository;

	@Override
	public List<CityRegistration> findAll(Null filter) {
		return null;
	}

	@Override
	public CityRegistration save(CityRegistration entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.findById(id).orElseThrow(() -> new GeneralException("City not found! Id: " + id + ", Type: " + CityRegistration.class.getName()));
		
		repository.deleteById(id);
	}

	@Override
	public CityRegistration findOne(Long id) {
		return null;
	}

	@Override
	public Long getIdFromInstance(CityRegistration entity) {
		return null;
	}

	@Override
	public List<CityRegistration> getAll() {
		return repository.findAllByOrderByNameAsc();
	}
}
