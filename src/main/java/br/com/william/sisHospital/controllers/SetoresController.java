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

import br.com.william.sisHospital.model.Setores;
import br.com.william.sisHospital.repository.SetoresRepository;

@RestController
@RequestMapping({"/setores"})
public class SetoresController {

   @Autowired
   private SetoresRepository repository;
   
   SetoresController(SetoresRepository setoresRepository) {
       this.repository = setoresRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Setores> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("setores") @Valid Setores setores, BindingResult bindingResult) {
	   Setores s = new Setores();
	   s.setCodigo(setores.getCodigo());
	   s.setNome(setores.getNome());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Setores>> violations = validator.validate(s);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Setores> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoSetor();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(s);
	   return consultaSetores();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("setorSelecionado") Setores setor) {
	   Setores s = new Setores();
	   if (setor != null && setor.getCodigo() != null) {
		   s.setCodigo(setor.getCodigo());
		   s.setNome(setor.getNome());
	   
		   repository.delete(s);
	   }
	   return consultaSetores();
   }
   
   @GetMapping
   public ModelAndView consultaSetores() {
	   ModelAndView consulta = new ModelAndView("consultaSetores");
	   consulta.addObject("setores", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-setor")
   public ModelAndView novoSetor() {
	   return new ModelAndView("novoSetor");
   }
   
   @PostMapping("editar-setor")
   public ModelAndView editarSetor(@ModelAttribute("setorSelecionado") Setores setor) {
	   ModelAndView modView = novoSetor();
	   modView.addObject("codigo", setor.getCodigo());
	   modView.addObject("nome", setor.getNome());

	   return modView;
   }
} 
