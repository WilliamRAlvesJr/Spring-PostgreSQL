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

import br.com.william.sisHospital.model.Pessoas;
import br.com.william.sisHospital.repository.PessoasRepository;

@RestController
@RequestMapping({"/pessoas"})
public class PessoasController {

   @Autowired
   private PessoasRepository repository;
   
   PessoasController(PessoasRepository pessoasRepository) {
       this.repository = pessoasRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Pessoas> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("pessoas") @Valid Pessoas pessoas, BindingResult bindingResult) {
	   Pessoas m = new Pessoas();
	   m.setCpf(pessoas.getCpf());
	   m.setNome(pessoas.getNome());
	   m.setTelefone(pessoas.getTelefone());

	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Pessoas>> violations = validator.validate(m);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Pessoas> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoPessoa();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(m);
	   return consultaPessoas();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("pessoaSelecionado") Pessoas pessoa) {
	   Pessoas m = new Pessoas();
	   if (pessoa != null && pessoa.getCpf() != null) {
		   m.setCpf(pessoa.getCpf());
		   m.setNome(pessoa.getNome());
		   m.setTelefone(pessoa.getTelefone());

		   repository.delete(m);
	   }
	   return consultaPessoas();
   }
   
   @GetMapping
   public ModelAndView consultaPessoas() {
	   ModelAndView consulta = new ModelAndView("consultaPessoas");
	   consulta.addObject("pessoas", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("nova-pessoa")
   public ModelAndView novoPessoa() {
	   return new ModelAndView("novoPessoa");
   }
   
   @PostMapping("editar-pessoa")
   public ModelAndView editarPessoa(@ModelAttribute("pessoaSelecionado") Pessoas pessoa) {
	   ModelAndView modView = novoPessoa();
	   modView.addObject("cpf", pessoa.getCpf());
	   modView.addObject("nome", pessoa.getNome());
	   modView.addObject("telefone", pessoa.getTelefone());

	   return modView;
   }
} 
