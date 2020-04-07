package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CAD_FORMA_PAGAMENTO")
@SequenceGenerator(name = CadastroFormaPagamento.SEQUENCE_NAME, sequenceName = CadastroFormaPagamento.SEQUENCE_NAME, allocationSize = 1)
public class CadastroFormaPagamento implements Serializable{
	
	private static final long serialVersionUID = 6787849843160533625L;

	protected static final String SEQUENCE_NAME = "SQ_CAD_FORMA_PAGAMENTO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="DESCRICAO")
	private String descricao;
}
