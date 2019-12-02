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
import br.com.william.sisHospital.model.Tratamentos;
import br.com.william.sisHospital.repository.PacientesRepository;
import br.com.william.sisHospital.repository.TratamentosRepository;

@RestController
@RequestMapping({"/tratamentos"})
public class TratamentosController {

   @Autowired
   private TratamentosRepository repository;

   @Autowired
   private PacientesRepository pacientesRepository;
   
   TratamentosController(TratamentosRepository tratamentosRepository) {
       this.repository = tratamentosRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Tratamentos> findAll(){
	   return repository.findAll();
   }
   
   @GetMapping("/api-pacientes")
   public List<Pacientes> findAllPacientes() {
	   return pacientesRepository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("tratamentos") @Valid Tratamentos tratamentos, BindingResult bindingResult) {
	   Tratamentos t = new Tratamentos();
	   t.setPaciente(tratamentos.getPaciente());
	   t.setMedico(tratamentos.getMedico());
	   t.setQuarto(tratamentos.getQuarto());
	   t.setEquipamento(tratamentos.getEquipamento());
	   t.setDtEntrada(tratamentos.getDtEntrada());
	   t.setDtSaida(tratamentos.getDtSaida());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Tratamentos>> violations = validator.validate(t);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Tratamentos> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoTratamento();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(t);
	   return consultaTratamentos();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("tratamentoSelecionado") Tratamentos tratamento) {
	   Tratamentos t = new Tratamentos();
	   if (tratamento != null && tratamento.getPaciente() != null) {
		   t.setPaciente(tratamento.getPaciente());
		   t.setMedico(tratamento.getMedico());
		   t.setQuarto(tratamento.getQuarto());
		   t.setEquipamento(tratamento.getEquipamento());
		   t.setDtEntrada(tratamento.getDtEntrada());
		   t.setDtSaida(tratamento.getDtSaida());
	   
		   repository.delete(t);
	   }
	   return consultaTratamentos();
   }
   
   @GetMapping
   public ModelAndView consultaTratamentos() {
	   ModelAndView consulta = new ModelAndView("consultaTratamentos");
	   consulta.addObject("tratamentos", findAll());
	   return consulta;
   }
   
   @GetMapping("novo-tratamento")
   public ModelAndView novoTratamento() {
	   ModelAndView novo = new ModelAndView("novoTratamento");
	   novo.addObject("pacientes", findAllPacientes());
	   return novo;
   }
   
   @PostMapping("editar-tratamento")
   public ModelAndView editarTratamento(@ModelAttribute("tratamentoSelecionado") Tratamentos tratamento) {
	   
	   ModelAndView modView = novoTratamento();
	   modView.addObject("medico", tratamento.getMedico());
	   modView.addObject("paciente", tratamento.getPaciente());
	   modView.addObject("quarto", tratamento.getQuarto());
	   modView.addObject("equipamento", tratamento.getEquipamento());
	   modView.addObject("dtEntrada", tratamento.getDtEntrada());
	   modView.addObject("dtSaida", tratamento.getDtSaida());

	   return modView;
   }
} 
