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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	
	@NotEmpty
	@Column(name="ADDRESS")
	private String address;
	
	@NotNull
	@Column(name="NUMBER")
	private Long number;
	
	@Column(name="COMPLEMENT")
	private String complement;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="REFERENCE")
	private String reference;
	
	@NotEmpty
	@Pattern(regexp = "^[DP]", message = "Withdrawal options: Delivery=D, Pick up=P")
	@Column(name="WITHDRAWAL")
	private Character withdrawal;
	
	@Column(name="USE_REGISTRATION_ADDRESS")
	private Character useRegistrationAddress;
	
	@NotNull
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@NotNull
	@Column(name="PHONE_CODE")
	private Long phoneCode;
	
	@Column(name="CEP")
	private Long cep;
	
	@OneToOne(mappedBy = "deliveryData")
	private SalesOrder salesOrder;
}
