package br.com.assuncao.arigato.entity;

import java.io.Serializable;
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
@Table(name="EMPLOYEE_REG")
public class EmployeeRegistration implements Serializable{
	
	private static final long serialVersionUID = -4165693220692185874L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	private EmployeePositionRegistration employeePositionRegistration;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="HIRE_DATE")
	private LocalDateTime hireDate;
	
	@ManyToOne
	private AccessLevel accessLevel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AddressRegistration addressRegistration;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="PHONE_CODE")
	private Long phoneCode;
	
	@OneToOne(mappedBy = "employeeRegistration")
	private SalesOrder salesOrder;
}
