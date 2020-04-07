package br.com.assuncao.arigato.entity.filter;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CadastroClienteFilter{
	
	private String nomeCliente;
	
	private BigDecimal telefoneCliente;
	
	private BigDecimal rgCliente;
	
	private BigDecimal cpfCliente;
}
