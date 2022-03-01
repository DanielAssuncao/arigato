package br.com.assuncao.arigato.business.service;

import java.util.List;

import br.com.assuncao.arigato.entity.CustomerRegistration;
import br.com.assuncao.arigato.entity.filter.CustomerRegistrationFilter;

public interface ICustomerRegistrationService extends ICrudService<CustomerRegistration, Long, CustomerRegistrationFilter>{

	List<CustomerRegistration> getAll();
}
