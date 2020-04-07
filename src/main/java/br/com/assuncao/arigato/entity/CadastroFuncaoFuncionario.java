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
@Table(name="CAD_FUNCAO_FUNCIONARIO")
@SequenceGenerator(name = CadastroFuncaoFuncionario.SEQUENCE_NAME, sequenceName = CadastroFuncaoFuncionario.SEQUENCE_NAME, allocationSize = 1)
public class CadastroFuncaoFuncionario implements Serializable{
	
	private static final long serialVersionUID = -3469531008016406833L;
	
	protected static final String SEQUENCE_NAME = "SQ_CAD_FUNCAO_FUNCIONARIO";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="DESCRICAO")
	private String descricao;
}
