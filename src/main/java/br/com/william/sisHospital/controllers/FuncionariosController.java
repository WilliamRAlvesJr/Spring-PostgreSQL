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

import br.com.william.sisHospital.model.Funcionarios;
import br.com.william.sisHospital.repository.FuncionariosRepository;

@RestController
@RequestMapping({"/funcionarios"})
public class FuncionariosController {

   @Autowired
   private FuncionariosRepository repository;
   
   FuncionariosController(FuncionariosRepository funcionariosRepository) {
       this.repository = funcionariosRepository;
   }
   
   // métodos do CRUD aqui
   
   @GetMapping("/api")
   public List<Funcionarios> findAll(){
	   return repository.findAll();
   }
   
   @PostMapping("/salvar")
   public ModelAndView salvar(@ModelAttribute("funcionarios") @Valid Funcionarios funcionarios, BindingResult bindingResult) {
	   Funcionarios f = new Funcionarios();
	   f.setCpf(funcionarios.getCpf());
	   f.setCodigo(funcionarios.getCodigo());
	   f.setTelefone(funcionarios.getTelefone());
	   f.setNome(funcionarios.getNome());
	   f.setDtAdmissao(funcionarios.getDtAdmissao());
	   f.setSetor(funcionarios.getSetor());

	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   Validator validator = factory.getValidator();
	   Set<ConstraintViolation<Funcionarios>> violations = validator.validate(f);

	   if (violations.size() > 0) {
		   for (ConstraintViolation<Funcionarios> violation : violations) {
			   System.err.println(violation.getMessage());
		   }
		   ModelAndView modView = novoFuncionario();
		   modView.addObject("erro", "Atenção, o comando não pode ser executa. Porfavor verifique.");
		   return modView;
	   }

	   repository.save(f);
	   return consultaFuncionarios();
   }
   
   @PostMapping("/excluir")
   public ModelAndView excluir(@ModelAttribute("funcionarioSelecionado") Funcionarios funcionario) {
	   Funcionarios f = new Funcionarios();
	   if (funcionario != null && funcionario.getCodigo() != null) {
		   f.setCpf(funcionario.getCpf());
		   f.setNome(funcionario.getNome());
		   f.setTelefone(funcionario.getTelefone());
		   f.setCodigo(funcionario.getCodigo());
		   f.setNome(funcionario.getNome());
		   f.setDtAdmissao(funcionario.getDtAdmissao());
		   f.setSetor(funcionario.getSetor());
	   
		   repository.delete(f);
	   }
	   return consultaFuncionarios();
   }
   
   @GetMapping
   public ModelAndView consultaFuncionarios() {
	   ModelAndView consulta = new ModelAndView("consultaFuncionarios");
	   consulta.addObject("funcionarios", findAll());
	   
	   return consulta;
   }
   
   @GetMapping("novo-funcionario")
   public ModelAndView novoFuncionario() {
	   return new ModelAndView("novoFuncionario");
   }
   
   @PostMapping("editar-funcionario")
   public ModelAndView editarFuncionario(@ModelAttribute("funcionarioSelecionado") Funcionarios funcionario) {
	   ModelAndView modView = novoFuncionario();
	   modView.addObject("cpf", funcionario.getCpf());
	   modView.addObject("codigo", funcionario.getCodigo());
	   modView.addObject("telefone", funcionario.getTelefone());
	   modView.addObject("nome", funcionario.getNome());
	   modView.addObject("dtAdmissao", funcionario.getDtAdmissao());
	   modView.addObject("setor", funcionario.getSetor());

	   return modView;
   }
} 
