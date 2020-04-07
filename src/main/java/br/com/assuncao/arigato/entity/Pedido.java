package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
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
@Table(name="PEDIDO")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME, sequenceName = Pedido.SEQUENCE_NAME, allocationSize = 1)
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = -5122633286651996633L;
	
	protected static final String SEQUENCE_NAME = "SQ_PEDIDO";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_PEDIDO_DETALHE", referencedColumnName = "ID")
	@OneToOne(cascade = CascadeType.ALL)
	private PedidoDetalhe pedidoDetalhe;
	
	@Column(name="VALOR_TOTAL")
	private Long valorTotal;
}
