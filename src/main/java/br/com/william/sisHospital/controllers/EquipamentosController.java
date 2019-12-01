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

import br.com.william.sisHospital.model.Equipamentos;
import br.com.william.sisHospital.repository.EquipamentosRepository;

@RestController
@RequestMapping({"/equipamentos"})
public class EquipamentosController {

   @Autowired
   private EquipamentosRepository repository;
   
   EquipamentosController(EquipamentosRepository equipamentosRepository) {
       this.repository = equipamentosRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Equipamentos> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("equipamentos") @Valid Equipamentos equipamentos, BindingResult bindingResult) {
	   Equipamentos e = new Equipamentos();
	   e.setCodigo(equipamentos.getCodigo());
	   e.setNome(equipamentos.getNome());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Equipamentos>> violations = validator.validate(e);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Equipamentos> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoEquipamento();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(e);
	   return consultaEquipamentos();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("equipamentoSelecionado") Equipamentos equipamento) {
	   Equipamentos e = new Equipamentos();
	   if (equipamento != null && equipamento.getCodigo() != null) {
		   e.setCodigo(equipamento.getCodigo());
		   e.setNome(equipamento.getNome());
	   
		   repository.delete(e);
	   }
	   return consultaEquipamentos();
   }
   
   @GetMapping
   public ModelAndView consultaEquipamentos() {
	   ModelAndView consulta = new ModelAndView("consultaEquipamentos");
	   consulta.addObject("equipamentos", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-equipamento")
   public ModelAndView novoEquipamento() {
	   return new ModelAndView("novoEquipamento");
   }
   
   @PostMapping("editar-equipamento")
   public ModelAndView editarEquipamento(@ModelAttribute("equipamentoSelecionado") Equipamentos equipamento) {
	   ModelAndView modView = novoEquipamento();
	   modView.addObject("codigo", equipamento.getCodigo());
	   modView.addObject("nome", equipamento.getNome());

	   return modView;
   }
} 
