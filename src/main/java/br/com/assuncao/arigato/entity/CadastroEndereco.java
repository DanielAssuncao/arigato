package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CAD_ENDERECO")
@SequenceGenerator(name = CadastroEndereco.SEQUENCE_NAME, sequenceName = CadastroEndereco.SEQUENCE_NAME, allocationSize = 1)
public class CadastroEndereco implements Serializable{
	
	private static final long serialVersionUID = 6645601442099650282L;
	
	protected static final String SEQUENCE_NAME = "SQ_CAD_ENDERECO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="NUMERO")
	private BigDecimal numero;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CEP")
	private BigDecimal cep;
	
	@Column(name="REFERENCIA")
	private String referencia;
	
	@JoinColumn(name="ID_CAD_CIDADE", referencedColumnName = "ID")
	@ManyToOne
	private CadastroCidade cadCidade;
}
