package br.com.william.sisHospital.model;

import java.time.LocalDate;

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
@IdClass(Pessoas.class)
public class Funcionarios extends Pessoas {

	private static final long serialVersionUID = 1L;

	@Id @NotNull
	private Integer codigo;
	
	@NotNull
	private LocalDate dtAdmissao;
	
	@NotNull
	private Integer setor;

}

