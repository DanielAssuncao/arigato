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
@Table(name="DADOS_ENTREGA")
@SequenceGenerator(name = DadosEntrega.SEQUENCE_NAME, sequenceName = DadosEntrega.SEQUENCE_NAME, allocationSize = 1)
public class DadosEntrega implements Serializable{
	
	private static final long serialVersionUID = -4552656882598827067L;
	
	protected static final String SEQUENCE_NAME = "SQ_DADOS_ENTREGA";

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
	
	@Column(name="REFERENCIA")
	private String referencia;
	
	@Column(name="RETIRADA")
	private Character retirada;
	
	@Column(name="UTILIZAR_ENDERECO_CAD")
	private Character utilizarEnderecoCadastrado;
	
	@Column(name="TELEFONE")
	private BigDecimal telefone;
	
	@Column(name="DDD_TELEFONE")
	private BigDecimal ddd;
	
	@Column(name="CEP")
	private BigDecimal cep;
}
