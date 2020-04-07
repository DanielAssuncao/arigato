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
@Table(name="PEDIDO_DETALHE")
@SequenceGenerator(name = PedidoDetalhe.SEQUENCE_NAME, sequenceName = PedidoDetalhe.SEQUENCE_NAME, allocationSize = 1)
public class PedidoDetalhe implements Serializable{
	
	private static final long serialVersionUID = -2754355710212628840L;

	protected static final String SEQUENCE_NAME = "SQ_PEDIDO_DETALHE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_PRODUTO", referencedColumnName = "ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@JoinColumn(name="ID_ADICIONAL", referencedColumnName = "ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Adicional Adicional;
}
