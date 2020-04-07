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
@Table(name="CAD_FUNCIONARIO")
@SequenceGenerator(name = CadastroFuncionario.SEQUENCE_NAME, sequenceName = CadastroFuncionario.SEQUENCE_NAME, allocationSize = 1)
public class CadastroFuncionario implements Serializable{
	
	private static final long serialVersionUID = -4165693220692185874L;
	
	protected static final String SEQUENCE_NAME = "SQ_CAD_FUNCIONARIO";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_CAD_FUNCAO_FUNCIONARIO", referencedColumnName = "ID")
	@ManyToOne
	private CadastroFuncaoFuncionario funcaoFuncionario;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="ADMISSAO")
	private LocalDateTime dataAdmissao;
	
	@JoinColumn(name="ID_CAD_NIVEL_ACESSO", referencedColumnName = "ID")
	@ManyToOne
	private NivelAcesso nivelAcesso;
	
	@JoinColumn(name="ID_CAD_ENDERECO", referencedColumnName = "ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private CadastroEndereco endereco;
	
	@Column(name="TELEFONE")
	private BigDecimal telefone;
	
	@Column(name="DDD_TELEFONE")
	private BigDecimal ddd;
}
