package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="CUSTOMER_ORDER")
public class CustomerOrder implements Serializable{
	
	private static final long serialVersionUID = -5122633286651996633L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name="ID_CUSTOMER_ORDER_DETAIL", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerOrderDetail customerOrderDetail;
	
	@Column(name="TOTAL_VALUE")
	private Float totalValue;
	
	@OneToOne(mappedBy = "customerOrder")
	private SalesOrder salesOrder;
}
