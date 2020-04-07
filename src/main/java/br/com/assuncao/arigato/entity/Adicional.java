package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADICIONAL")
@SequenceGenerator(name = Adicional.SEQUENCE_NAME, sequenceName = Adicional.SEQUENCE_NAME, allocationSize = 1)
public class Adicional implements Serializable{
	
	private static final long serialVersionUID = 5056733604482444624L;

	protected static final String SEQUENCE_NAME = "SQ_ADICIONAL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_CAD_ADICIONAL", referencedColumnName = "ID")
	@OneToOne
	private CadastroAdicional cadAdicional;
	
	@Column(name="QUANTIDADE")
	private Long quantidade;
	
	@Column(name="VALOR_UNITARIO")
	private Long valorUnitario;
	
	@Column(name="VALOR_TOTAL")
	private Long valorTotal;
}
