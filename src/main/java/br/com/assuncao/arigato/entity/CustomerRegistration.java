package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="CUSTOMER_REG")
public class CustomerRegistration implements Serializable{
	
	private static final long serialVersionUID = 4717910140438109664L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = ApplicationConstant.REGEX_NAME_FORMAT)
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;
	
	@NotNull
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="RG")
	private Long rg;
	
	@NotNull
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="CPF")
	private Long cpf;
	
	@NotNull
	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name="PHONE_CODE")
	private Long phoneCode;
	
	@Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$", message = ApplicationConstant.REGEX_EMAIL_FORMAT)
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name="REGISTRATION_DATE")
	private LocalDateTime registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AddressRegistration addressRegistration;
	
	@OneToOne(mappedBy = "customerRegistration")
	private SalesOrder salesOrder;
}
