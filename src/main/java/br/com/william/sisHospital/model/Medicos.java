package br.com.william.sisHospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@IdClass(FuncionariosTY.class)
public class Medicos extends FuncionariosTY {

	private static final long serialVersionUID = 1L;

	@Id @NotNull
	private Integer crm;
	
	@NotEmpty
	private String especialidade;

}

