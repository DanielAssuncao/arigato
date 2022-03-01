package br.com.assuncao.arigato.presentation.controller;

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
	
	/**
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public ResponseEntity<?> save() {
	
	CadastroEndereco cadEndereco = new CadastroEndereco();
	cadEndereco.setId(null);
	cadEndereco.setLogradouro("Rua Italia");
	cadEndereco.setNumero(Long.valueOf(60));
	cadEndereco.setBairro("Centro");
	cadEndereco.setCep(Long.valueOf(14800123));
	
	CadastroCliente cadCliente = new CadastroCliente();
	cadCliente.setId(null);
	cadCliente.setNome("Daniel Gomes");
	cadCliente.setCpf(Long.valueOf(1234));
	cadCliente.setRg(Long.valueOf(5678));
	cadCliente.setDataNascimento(LocalDateTime.of(1987, 06, 30, 0, 0));
	cadCliente.setDataCadastro(LocalDateTime.now());
	cadCliente.setDdd(Long.valueOf(016));
	cadCliente.setTelefone(Long.valueOf(123456789));
	cadCliente.setCadEndereco(cadEndereco);
	
	CadastroCliente salvo = new CadastroCliente();
	
	try {	
		salvo = service.save(cadCliente);
	} catch (Exception e) {
		 e.getMessage();
	}
	
	return ResponseEntity.ok().body(salvo);
	}**/
}

