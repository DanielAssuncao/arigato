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
@Table(name="CUSTOMER_ORDER_DETAIL")
public class CustomerOrderDetail implements Serializable{
	
	private static final long serialVersionUID = -2754355710212628840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name="ID_PRODUCT", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@JoinColumn(name="ID_ADD_INGREDIENT", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private AdditionalIngredient additionalIngredient;
	
	@OneToOne(mappedBy = "customerOrderDetail")
	private CustomerOrder customerOrder;
}
