package academy.wakanda.pessoaendereco.pessoa.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
@Value
@Builder
public class PessoaAlteracaoRequest {
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
}
