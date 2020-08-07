package br.com.assuncao.arigato.entity.filter;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CadastroClienteFilter{
	
	private String nome;
	
	private BigDecimal telefone;
	
	private BigDecimal rg;
	
	private BigDecimal cpf;
}
