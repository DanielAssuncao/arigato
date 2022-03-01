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
@Table(name="PAYMENT_METHOD_REG")
public class PaymentMethodRegistration implements Serializable{
	
	private static final long serialVersionUID = 6787849843160533625L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne(mappedBy = "paymentMethodRegistration")
	private SalesOrder salesOrder;
}
