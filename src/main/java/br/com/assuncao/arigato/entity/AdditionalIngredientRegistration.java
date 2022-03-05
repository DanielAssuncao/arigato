package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="ADD_INGREDIENT_REG")
public class AdditionalIngredientRegistration implements Serializable{
	
	private static final long serialVersionUID = 8360026310792763659L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(name="NAME")
	private String name;
	
	@NotNull
	@Min(value = 0)
	@Column(name="VALUE")
	private Float value;
	
	@OneToOne(mappedBy = "additionalIngredientRegistration")
    private AdditionalIngredient additionalIngredient;
}
