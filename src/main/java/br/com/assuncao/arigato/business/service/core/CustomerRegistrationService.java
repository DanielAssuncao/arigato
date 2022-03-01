package br.com.assuncao.arigato.business.service.core;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.assuncao.arigato.business.service.ICustomerRegistrationService;
import br.com.assuncao.arigato.entity.CustomerRegistration;
import br.com.assuncao.arigato.entity.filter.CustomerRegistrationFilter;
import br.com.assuncao.arigato.exceptions.GeneralException;
import br.com.assuncao.arigato.persistence.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationService implements ICustomerRegistrationService{

	@Autowired
	private CustomerRegistrationRepository repository;

	@Override
	public List<CustomerRegistration> findAll(CustomerRegistrationFilter filter) {
		return repository.getAll(filter.getName(), filter.getPhoneNumber(), filter.getRg(), filter.getCpf());
	}

	@Override
	@Transactional
	public CustomerRegistration save(CustomerRegistration entity) {
		fieldsValidation(entity);
		registrationDateComplete(entity);
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.findById(id).orElseThrow(() -> new GeneralException("Customer not found! Id: " + id + ", Tipo: " + CustomerRegistration.class.getName()));
		
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public CustomerRegistration findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new GeneralException(
				"Objeto n�o encontrado! Id: " + id + ", Tipo: " + CustomerRegistration.class.getName()));
	}

	@Override
	public Long getIdFromInstance(CustomerRegistration entidade) {
		return entidade.getId();
	}

	@Override
	@Transactional
	public List<CustomerRegistration> getAll() {
		return repository.findAllByOrderByNameAsc();
	}
	
	private void fieldsValidation(CustomerRegistration customerRegistration) {
		if(customerRegistration.getName().isBlank()) {
			throw new GeneralException("The field NAME must be filled!");
		}
		if(repository.getByCpf(customerRegistration.getCpf(), customerRegistration.getId()) != null) {
			throw new GeneralException("The entered CPF is already registered in the system!");
		}
		if(customerRegistration.getCpf() == null) {
			throw new GeneralException("The field CPF must be filled!");
		}
		if(customerRegistration.getAddressRegistration().getAddress().isBlank()) {
			throw new GeneralException("The field ADDRESS must be filled!");
		}
	}
	
	private void registrationDateComplete(CustomerRegistration customerRegistration) {
		if (customerRegistration.getId() == null) {
			customerRegistration.setRegistrationDate(LocalDateTime.now());
		} else {
			CustomerRegistration registrationDate = new CustomerRegistration();
			registrationDate = this.findOne(customerRegistration.getId());
			customerRegistration.setRegistrationDate(registrationDate.getRegistrationDate());
		}
	}
}
