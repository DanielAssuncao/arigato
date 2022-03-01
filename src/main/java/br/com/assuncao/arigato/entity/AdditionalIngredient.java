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
@Table(name="ADD_INGREDIENT")
public class AdditionalIngredient implements Serializable{
	
	private static final long serialVersionUID = 5056733604482444624L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name="ID_ADD_INGREDIENT_REG", referencedColumnName = "id")
	@OneToOne
	private AdditionalIngredientRegistration additionalIngredientRegistration;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	@Column(name="UNIT_VALUE")
	private Float unitValue;
	
	@Column(name="TOTAL_VALUE")
	private Float totalValue;
	
	@OneToOne(mappedBy = "additionalIngredient")
	private CustomerOrderDetail customerOrderDetail;
}
