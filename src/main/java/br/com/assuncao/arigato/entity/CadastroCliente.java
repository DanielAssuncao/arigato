package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
@Table(name="CAD_CLIENTE")
@SequenceGenerator(name = CadastroCliente.SEQUENCE_NAME, sequenceName = CadastroCliente.SEQUENCE_NAME, allocationSize = 1)
public class CadastroCliente implements Serializable{
	
	private static final long serialVersionUID = 4717910140438109664L;
	
	protected static final String SEQUENCE_NAME = "SQ_CAD_CLIENTE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DATA_NASCIMENTO")
	private LocalDateTime dataNascimento;
	
	@Column(name="TELEFONE")
	private BigDecimal telefone;
	
	@Column(name="RG")
	private BigDecimal rg;
	
	@Column(name="CPF")
	private BigDecimal cpf;
	
	@Column(name="DATA_CADASTRO")
	private LocalDateTime dataCadastro;
	
	@JoinColumn(name="ID_CAD_ENDERECO", referencedColumnName = "ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private CadastroEndereco cadEndereco;
	
	@Column(name="DDD_TELEFONE")
	private BigDecimal ddd;
}
