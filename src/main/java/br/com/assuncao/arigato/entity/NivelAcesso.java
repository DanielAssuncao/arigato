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
@Table(name="NIVEL_ACESSO")
@SequenceGenerator(name = NivelAcesso.SEQUENCE_NAME, sequenceName = NivelAcesso.SEQUENCE_NAME, allocationSize = 1)
public class NivelAcesso implements Serializable{
	
	private static final long serialVersionUID = -7154470193602865814L;
	
	protected static final String SEQUENCE_NAME = "SQ_NIVEL_ACESSO";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@Column(name="NIVEL")
	private Character nivel;
}
