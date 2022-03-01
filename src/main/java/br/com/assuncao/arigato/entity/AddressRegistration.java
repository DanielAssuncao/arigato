package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="ADDRESS_REG")
public class AddressRegistration implements Serializable{
	
	private static final long serialVersionUID = 6645601442099650282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="NUMBER")
	private Long number;
	
	@Column(name="COMPLEMENT")
	private String complement;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="CEP")
	private Long cep;
	
	@Column(name="REFERENCE")
	private String reference;
	
	@ManyToOne
	private CityRegistration cityRegistration;
}
