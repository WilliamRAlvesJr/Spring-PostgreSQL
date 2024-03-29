package br.com.william.sisHospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@IdClass(PessoasTY.class)
public class Pacientes extends PessoasTY {
	
	private static final long serialVersionUID = 1L;

	@Id @NotNull
	private Integer ctSaude;
	
	@NotNull
	private Integer convenio;
}

