package br.com.william.sisHospital.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class Pessoas implements Serializable {

	@Id @NotNull
	protected String cpf;
	
	@Id @NotEmpty
	protected String telefones;
	
	@NotEmpty
	protected String nome;

}

