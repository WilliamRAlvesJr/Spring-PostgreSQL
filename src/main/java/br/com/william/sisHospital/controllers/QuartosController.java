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

import br.com.william.sisHospital.model.Quartos;
import br.com.william.sisHospital.repository.QuartosRepository;

@RestController
@RequestMapping({"/quartos"})
public class QuartosController {

   @Autowired
   private QuartosRepository repository;
   
   QuartosController(QuartosRepository quartosRepository) {
       this.repository = quartosRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Quartos> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("quartos") @Valid Quartos quartos, BindingResult bindingResult) {
	   Quartos q = new Quartos();
	   q.setCodigo(quartos.getCodigo());
	   q.setNome(quartos.getNome());
	   q.setSetor(quartos.getSetor());
	   q.setEquipamento(quartos.getEquipamento());
	   
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Quartos>> violations = validator.validate(q);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Quartos> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoQuarto();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(q);
	   return consultaQuartos();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("quartoSelecionado") Quartos quarto) {
	   Quartos q = new Quartos();
	   if (quarto != null && quarto.getCodigo() != null) {
		   q.setCodigo(quarto.getCodigo());
		   q.setNome(quarto.getNome());
		   q.setEquipamento(quarto.getEquipamento());
		   q.setSetor(quarto.getSetor());
		   
		   repository.delete(q);
	   }
	   return consultaQuartos();
   }
   
   @GetMapping
   public ModelAndView consultaQuartos() {
	   ModelAndView consulta = new ModelAndView("consultaQuartos");
	   consulta.addObject("quartos", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-quarto")
   public ModelAndView novoQuarto() {
	   return new ModelAndView("novoQuarto");
   }
   
   @PostMapping("editar-quarto")
   public ModelAndView editarQuarto(@ModelAttribute("quartoSelecionado") Quartos quarto) {
	   ModelAndView modView = novoQuarto();
	   modView.addObject("codigo", quarto.getCodigo());
	   modView.addObject("nome", quarto.getNome());
	   modView.addObject("setor", quarto.getSetor());
	   modView.addObject("equipamento", quarto.getEquipamento());

	   return modView;
   }
} 
