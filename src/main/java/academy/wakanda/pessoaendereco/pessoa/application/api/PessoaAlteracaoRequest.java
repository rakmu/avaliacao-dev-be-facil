package academy.wakanda.pessoaendereco.pessoa.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class PessoaAlteracaoRequest {
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
}
