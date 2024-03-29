package br.com.william.sisHospital.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.william.sisHospital.model.Pacientes;
import br.com.william.sisHospital.repository.PacientesRepository;

@RestController
@RequestMapping({"/pacientes"})
public class PacientesController {

   @Autowired
   private PacientesRepository repository;
   
   PacientesController(PacientesRepository pacientesRepository) {
       this.repository = pacientesRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Pacientes> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("pacientes") @Valid Pacientes pacientes, BindingResult bindingResult) {
	   Pacientes p = new Pacientes();
	   p.setCtSaude(pacientes.getCtSaude());
	   p.setCpf(pacientes.getCpf());
	   p.setNome(pacientes.getNome());
	   p.setConvenio(pacientes.getConvenio());
	   p.setTelefone(pacientes.getTelefone());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Pacientes>> violations = validator.validate(p);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Pacientes> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoPaciente();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(p);
	   return consultaPacientes();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("pacienteSelecionado") Pacientes paciente) {
	   Pacientes p = new Pacientes();
	   if (paciente != null && paciente.getCpf() != null) {
		   p.setCtSaude(paciente.getCtSaude());
		   p.setCpf(paciente.getCpf());
		   p.setNome(paciente.getNome());
		   p.setConvenio(paciente.getConvenio());
		   p.setTelefone(paciente.getTelefone());
	   
		   repository.delete(p);
	   }
	   return consultaPacientes();
   }
   
   @GetMapping
   public ModelAndView consultaPacientes() {
	   ModelAndView consulta = new ModelAndView("consultaPacientes");
	   consulta.addObject("pacientes", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-paciente")
   public ModelAndView novoPaciente() {
	   return new ModelAndView("novoPaciente");
   }
   
   @PostMapping("editar-paciente")
   public ModelAndView editarPaciente(@ModelAttribute("pacienteSelecionado") Pacientes paciente) {
	   ModelAndView modView = novoPaciente();
	   modView.addObject("cpf", paciente.getCpf());
	   modView.addObject("nome", paciente.getNome());
	   modView.addObject("convenio", paciente.getConvenio());
	   modView.addObject("telefone", paciente.getTelefone());
	   modView.addObject("ctSaude", paciente.getCtSaude());

	   return modView;
   }
} 
