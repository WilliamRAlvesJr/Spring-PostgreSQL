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
public class PessoasTY implements Serializable {

	@Id @NotNull
	protected String cpf;
	
	@NotNull
	protected String telefone;
	
	@NotEmpty
	protected String nome;

}

