package br.com.assuncao.arigato.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.assuncao.arigato.business.service.ICityRegistrationService;
import br.com.assuncao.arigato.business.service.ICustomerRegistrationService;
import br.com.assuncao.arigato.entity.CityRegistration;
import br.com.assuncao.arigato.entity.CustomerRegistration;
import br.com.assuncao.arigato.entity.filter.CustomerRegistrationFilter;

@RestController
@RequestMapping(value="/customer-registration")
public class CustomerRegistrationController extends CrudBaseController<CustomerRegistration, Long, CustomerRegistrationFilter, ICustomerRegistrationService>{
	
	protected static final String CONTEXT = "/customer-registration.do";
	
	private ICityRegistrationService cityRegistrationService;
	
	@Autowired
	public CustomerRegistrationController(ICustomerRegistrationService service, ICityRegistrationService cityRegistrationService) {
		super(CONTEXT, service);
		this.cityRegistrationService = cityRegistrationService;
	}
	
	@RequestMapping(value = "/findCityRegistration", method=RequestMethod.GET)
	protected List<CityRegistration> findCityRegistration() { 
		List<CityRegistration> listCity = new ArrayList<>();
	
	try {
		listCity = cityRegistrationService.getAll();
	} catch (Exception e) {
		 e.getMessage();
	}
	
	return listCity;
	}
}

