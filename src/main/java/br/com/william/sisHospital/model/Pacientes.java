package br.com.william.sisHospital.model;

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
public class Pacientes {
	
	@Id @NotEmpty(message = "cpf cannot be Empty")
	private String cpf;

    @NotEmpty(message = "Name cannot be Empty")
	private String nome;
	
    @NotNull(message = "Convenio cannot be null")
	private Integer convenio;
}

