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

import br.com.william.sisHospital.model.Convenios;
import br.com.william.sisHospital.repository.ConveniosRepository;

@RestController
@RequestMapping({"/convenios"})
public class ConveniosController {

   @Autowired
   private ConveniosRepository repository;
   
   ConveniosController(ConveniosRepository convenioRepository) {
       this.repository = convenioRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Convenios> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("convenios") @Valid Convenios convenios, BindingResult bindingResult) {
	   Convenios c = new Convenios();
	   c.setCodigo(convenios.getCodigo());
	   c.setNome(convenios.getNome());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Convenios>> violations = validator.validate(c);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Convenios> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoConvenio();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(c);
	   return consultaConvenios();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("convenioSelecionado") Convenios convenios) {
	   Convenios c = new Convenios();
	   if (convenios != null && convenios.getCodigo() != null) {
		   c.setCodigo(convenios.getCodigo());
		   c.setNome(convenios.getNome());
	   
		   repository.delete(c);
	   }
	   return consultaConvenios();
   }
   
   @GetMapping
   public ModelAndView consultaConvenios() {
	   ModelAndView consulta = new ModelAndView("consultaConvenios");
	   consulta.addObject("convenios", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-convenio")
   public ModelAndView novoConvenio() {
	   return new ModelAndView("novoConvenio");
   }
   
   @PostMapping("editar-convenio")
   public ModelAndView editarConvenio(@ModelAttribute("convenioSelecionado") Convenios convenio) {
	   ModelAndView modView = novoConvenio();
	   modView.addObject("codigo", convenio.getCodigo());
	   modView.addObject("nome", convenio.getNome());

	   return modView;
   }
} 
