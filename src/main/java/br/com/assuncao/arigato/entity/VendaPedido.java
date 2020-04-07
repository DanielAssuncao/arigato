package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name="VENDA_PEDIDO")
@SequenceGenerator(name = VendaPedido.SEQUENCE_NAME, sequenceName = VendaPedido.SEQUENCE_NAME, allocationSize = 1)
public class VendaPedido implements Serializable{
	
	private static final long serialVersionUID = -2886935946556700015L;

	protected static final String SEQUENCE_NAME = "SQ_VENDA_PEDIDO";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = SEQUENCE_NAME)
	@Column(name="ID")
	private BigDecimal id;
	
	@JoinColumn(name="ID_PEDIDO", referencedColumnName = "ID")
	@OneToOne
	private Pedido pedido;
	
	@JoinColumn(name="ID_CAD_FORMA_PAGAMENTO", referencedColumnName = "ID")
	@OneToOne
	private CadastroFormaPagamento cadFormaPagamento;
	
	@JoinColumn(name="ID_CAD_FUNCIONARIO", referencedColumnName = "ID")
	@OneToOne
	private CadastroFuncionario cadFuncionario;
	
	@JoinColumn(name="ID_CAD_CLIENTE", referencedColumnName = "ID")
	@OneToOne
	private CadastroCliente cadCliente;
	
	@Column(name="DESCONTO")
	private BigDecimal desconto;
	
	@Column(name="VALOR_TOTAL_VENDA")
	private Long valorTotalVenda;
	
	@Column(name="DATA")
	private LocalDateTime dataVenda;
	
	@Column(name="STATUS")
	private Character status;
	
	@JoinColumn(name="ID_DADOS_ENTREGA", referencedColumnName = "ID")
	@OneToOne
	private DadosEntrega dadosEntrega;
}
