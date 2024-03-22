package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaEnderecoRequest;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class PessoaEnderecoApplication {
	@GetMapping
	public String getHomeTeste() {
		return "Pessoa Endereco - API Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(PessoaEnderecoApplication.class, args);

	}

}
