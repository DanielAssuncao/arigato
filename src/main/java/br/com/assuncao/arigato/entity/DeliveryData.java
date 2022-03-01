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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="DELIVERY_DATA")
public class DeliveryData implements Serializable{
	
	private static final long serialVersionUID = -4552656882598827067L;

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
	
	@Column(name="REFERENCE")
	private String reference;
	
	@Column(name="WITHDRAWAL")
	private Character withdrawal;
	
	@Column(name="USE_REGISTRATION_ADDRESS")
	private Character useRegistrationAddress;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="PHONE_CODE")
	private Long phoneCode;
	
	@Column(name="CEP")
	private Long cep;
	
	@OneToOne(mappedBy = "deliveryData")
	private SalesOrder salesOrder;
}
