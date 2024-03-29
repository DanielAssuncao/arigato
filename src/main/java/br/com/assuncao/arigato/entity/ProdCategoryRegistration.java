package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="PROD_CATEGORY_REG")
public class ProdCategoryRegistration implements Serializable {
	
	private static final long serialVersionUID = -1365928472970707589L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotEmpty
	@Column(name="DESCRIPTION")
	private String description;
}