package br.com.assuncao.arigato.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="SALES_ORDER")
public class SalesOrder implements Serializable{
	
	private static final long serialVersionUID = -2886935946556700015L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name="ID_CUSTOMER_ORDER", referencedColumnName = "id")
	@OneToOne
	private CustomerOrder customerOrder;
	
	@JoinColumn(name="ID_CUSTOMER", referencedColumnName = "id")
	@OneToOne
	private CustomerRegistration customerRegistration;
	
	@JoinColumn(name="ID_PAYMENT_METHOD_REG", referencedColumnName = "id")
	@OneToOne
	private PaymentMethodRegistration paymentMethodRegistration;
	
	@JoinColumn(name="ID_EMPLOYEE_REG", referencedColumnName = "id")
	@OneToOne
	private EmployeeRegistration employeeRegistration;
	
	@Min(value = 0)
	@Column(name="DISCOUNT")
	private Long discount;
	
	@Min(value = 0)
	@Column(name="SALES_TOTAL_VALUE")
	private Float salesTotalValue;
	
	@Column(name="SALES_DATE")
	private LocalDateTime salesDate;
	
	@Column(name="STATUS")
	private Character status;
	
	@JoinColumn(name="ID_DELIVERY_DATA", referencedColumnName = "id")
	@OneToOne
	private DeliveryData deliveryData;
}
