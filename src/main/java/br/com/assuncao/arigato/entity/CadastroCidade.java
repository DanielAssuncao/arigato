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
@Table(name="CAD_CIDADE")
@SequenceGenerator(name = CadastroCidade.SEQUENCE_NAME, sequenceName = CadastroCidade.SEQUENCE_NAME, allocationSize = 1)
public class CadastroCidade implements Serializable{
	
	private static final long serialVersionUID = 6078476922515975508L;
	
	protected static final String SEQUENCE_NAME = "SQ_CAD_CIDADE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="NOME")
	private String nome;
}
