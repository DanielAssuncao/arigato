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
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="RG")
	private Long rg;
	
	@Column(name="CPF")
	private Long cpf;
	
	@Column(name="REGISTRATION_DATE")
	private LocalDateTime registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AddressRegistration addressRegistration;
	
	@Column(name="PHONE_CODE")
	private Long phoneCode;
	
	@OneToOne(mappedBy = "customerRegistration")
	private SalesOrder salesOrder;
}
