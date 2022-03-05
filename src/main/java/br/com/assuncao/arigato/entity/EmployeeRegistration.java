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
@Table(name = "EMPLOYEE_REG")
public class EmployeeRegistration implements Serializable {

	private static final long serialVersionUID = -4165693220692185874L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	private EmployeePositionRegistration employeePositionRegistration;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%<^&*?]{4,}$", message = "Enter a password of 4 or more characters")
	private String password;

	@Column(name = "HIRE_DATE")
	private LocalDateTime hireDate;

	@ManyToOne
	private AccessLevel accessLevel;

	@ManyToOne(cascade = CascadeType.ALL)
	private AddressRegistration addressRegistration;

	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@Pattern(regexp = "^\\d+$", message = ApplicationConstant.REGEX_ONLY_NUMBERS_ALLOWED)
	@Column(name = "PHONE_CODE")
	private Long phoneCode;

	@Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$", message = ApplicationConstant.REGEX_EMAIL_FORMAT)
	@Column(name = "EMAIL")
	private String email;

	@OneToOne(mappedBy = "employeeRegistration")
	private SalesOrder salesOrder;
}
