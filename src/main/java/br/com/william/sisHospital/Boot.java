package br.com.william.sisHospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.william.sisHospital.model.Pacientes;
import br.com.william.sisHospital.repository.PacientesRepository;

@SpringBootApplication
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    @Bean
    CommandLineRunner init(PacientesRepository repository) {
    	return (args) -> {
	    	Pacientes p = new Pacientes();
//	    	p.setCpf("12345123451");
//	    	p.setNome("Maria Antonia");
//	    	p.setConvenio(2);
//	    	repository.save(p);    
    	};
    }
}