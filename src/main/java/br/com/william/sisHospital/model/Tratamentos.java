package br.com.william.sisHospital.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(Tratamentos.class)
public class Tratamentos implements Serializable {
	
	private static final long serialVersionUID = 1L;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "medico", referencedColumnName = "crm")
//	private Medicos medico;
//	
//	@Id
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "paciente", referencedColumnName = "ctSaude")
//	private Pacientes paciente;
//	
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "quarto", referencedColumnName = "codigo")
//	private Quartos quarto;
//	
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "equipamento", referencedColumnName = "codigo")
//	private Equipamentos equipamento; 
	
	@NotNull
	private Integer medico;
	
	@Id @NotNull
	private Integer paciente;
	
	@NotNull
	private Integer quarto;
	
	@NotNull
	private Integer equipamento;
	
	@NotNull
	private Date dtEntrada;

	@NotNull
	private Date dtSaida;
}

