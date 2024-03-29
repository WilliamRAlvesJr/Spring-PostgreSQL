package br.com.william.sisHospital.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoas {

	@Id @NotNull
	private String cpf;
	
	@NotNull
	private String telefone;
	
	@NotEmpty
	private String nome;

}

