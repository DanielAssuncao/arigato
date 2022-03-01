package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
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
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 2033090590596377882L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name="ID_PRODUCT_REG", referencedColumnName = "id")
	@OneToOne
	private ProductRegistration productRegistration;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	@Column(name="UNIT_VALUE")
	private Float unitValue;
	
	@Column(name="TOTAL_VALUE")
	private Float totalValue;
	
	@Column(name="OBSERVATION")
	private String observation;
	
	@OneToOne(mappedBy = "product")
	private CustomerOrderDetail customerOrderDetail;
}
