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

import br.com.william.sisHospital.model.Medicos;
import br.com.william.sisHospital.repository.MedicosRepository;

@RestController
@RequestMapping({"/medicos"})
public class MedicosController {

   @Autowired
   private MedicosRepository repository;
   
   MedicosController(MedicosRepository medicosRepository) {
       this.repository = medicosRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Medicos> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("medicos") @Valid Medicos medicos, BindingResult bindingResult) {
	   Medicos m = new Medicos();
	   m.setCpf(medicos.getCpf());
	   m.setCodigo(medicos.getCodigo());
	   m.setTelefone(medicos.getTelefone());
	   m.setNome(medicos.getNome());
	   m.setDtAdmissao(medicos.getDtAdmissao());
	   m.setSetor(medicos.getSetor());
	   m.setCrm(medicos.getCrm());
	   m.setEspecialidade(medicos.getEspecialidade());

	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Medicos>> violations = validator.validate(m);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Medicos> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoMedico();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(m);
	   return consultaMedicos();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("medicoSelecionado") Medicos medico) {
	   Medicos m = new Medicos();
	   if (medico != null && medico.getCodigo() != null) {
		   m.setCpf(medico.getCpf());
		   m.setNome(medico.getNome());
		   m.setTelefone(medico.getTelefone());
		   m.setCodigo(medico.getCodigo());
		   m.setNome(medico.getNome());
		   m.setDtAdmissao(medico.getDtAdmissao());
		   m.setSetor(medico.getSetor());
		   m.setCrm(medico.getCrm());
		   m.setEspecialidade(medico.getEspecialidade());

		   repository.delete(m);
	   }
	   return consultaMedicos();
   }
   
   @GetMapping
   public ModelAndView consultaMedicos() {
	   ModelAndView consulta = new ModelAndView("consultaMedicos");
	   consulta.addObject("medicos", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-medico")
   public ModelAndView novoMedico() {
	   return new ModelAndView("novoMedico");
   }
   
   @PostMapping("editar-medico")
   public ModelAndView editarMedico(@ModelAttribute("medicoSelecionado") Medicos medico) {
	   ModelAndView modView = novoMedico();
	   modView.addObject("cpf", medico.getCpf());
	   modView.addObject("codigo", medico.getCodigo());
	   modView.addObject("telefone", medico.getTelefone());
	   modView.addObject("nome", medico.getNome());
	   modView.addObject("dtAdmissao", medico.getDtAdmissao());
	   modView.addObject("setor", medico.getSetor());
	   modView.addObject("crm", medico.getCrm());
	   modView.addObject("especialidade", medico.getEspecialidade());

	   return modView;
   }
} 
