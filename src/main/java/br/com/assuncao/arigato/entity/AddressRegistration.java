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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.assuncao.arigato.util.ApplicationConstant;
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
	
	@NotNull
	@Column(name="ADDRESS")
	private String address;
	
	@NotNull
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="NUMBER")
	private Long number;
	
	@Column(name="COMPLEMENT")
	private String complement;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="CEP")
	private Long cep;
	
	@Column(name="REFERENCE")
	private String reference;
	
	@ManyToOne
	private CityRegistration cityRegistration;
}
