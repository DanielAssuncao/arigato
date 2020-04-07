package br.com.assuncao.arigato.entity;

import java.io.Serializable;

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
@Table(name="CAD_CATEGORIA")
@SequenceGenerator(name = CadastroCategoria.SEQUENCE_NAME, sequenceName = CadastroCategoria.SEQUENCE_NAME, allocationSize = 1)
public class CadastroCategoria implements Serializable {
	
	private static final long serialVersionUID = -1365928472970707589L;

	protected static final String SEQUENCE_NAME = "SQ_CAD_CATEGORIA";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="DESCRICAO")
	private String descricao;
}