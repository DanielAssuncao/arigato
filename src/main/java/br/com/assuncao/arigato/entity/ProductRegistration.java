package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="PRODUCT_REG")
public class ProductRegistration implements Serializable{
	
	private static final long serialVersionUID = 2033090590596377882L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Min(value = 0)
	@Column(name="VALUE")
	private Float value;
	
	@ManyToOne
	private ProdCategoryRegistration prodCategoryRegistration;
	
	@OneToOne(mappedBy = "productRegistration")
	private Product product;
}
