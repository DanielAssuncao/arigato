package br.com.assuncao.arigato.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Cacheable(false)
@Table(name="ACCESS_LEVEL")
public class AccessLevel implements Serializable{
	
	private static final long serialVersionUID = -7154470193602865814L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@NotEmpty
	@Pattern(regexp = "^[AEC]", message = "Access level options: Admin = A, Employee=E, Customer=C.")
	@Column(name="LEVEL")
	private Character level;
}
