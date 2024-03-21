package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class PessoaRequest {

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @OneToMany
    private List<Endereco> endereco;

}
