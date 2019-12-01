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
public class Quartos {
	
	@Id @NotNull
	private Integer codigo;

	@NotEmpty
	private String nome;

	@NotNull
	private Integer setor;

	@NotNull
	private Integer equipamento; 
}

