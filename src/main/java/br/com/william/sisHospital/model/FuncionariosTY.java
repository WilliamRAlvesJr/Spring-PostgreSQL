package br.com.william.sisHospital.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@MappedSuperclass
public class FuncionariosTY extends PessoasTY {

	private static final long serialVersionUID = 1L;

	@Id @NotNull
	private Integer codigo;
	
	@NotNull
	private Date dtAdmissao;
	
	@NotNull
	private Integer setor;

}

