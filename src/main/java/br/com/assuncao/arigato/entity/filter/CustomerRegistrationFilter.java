package br.com.assuncao.arigato.entity.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerRegistrationFilter{
	
	private String name;
	
	private Long phoneNumber;
	
	private Long rg;
	
	private Long cpf;
}
