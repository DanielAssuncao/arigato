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
@Table(name="PRODUTO")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME, allocationSize = 1)
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 2033090590596377882L;
	
	protected static final String SEQUENCE_NAME = "SQ_PRODUTO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_CAD_PRODUTO", referencedColumnName = "ID")
	@OneToOne
	private CadastroProduto cadProduto;
	
	@Column(name="QUANTIDADE")
	private Long quantidade;
	
	@Column(name="VALOR_UNITARIO")
	private Long valorUnitario;
	
	@Column(name="VALOR_TOTAL")
	private Long valorTotal;
	
	@Column(name="OBSERVACAO")
	private String observacao;
}
