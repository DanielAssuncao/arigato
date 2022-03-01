package br.com.assuncao.arigato.business.service;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;

import br.com.assuncao.arigato.entity.CityRegistration;

public interface ICityRegistrationService extends ICrudService<CityRegistration, Long, Null>{
	
	List<CityRegistration> getAll();
}
