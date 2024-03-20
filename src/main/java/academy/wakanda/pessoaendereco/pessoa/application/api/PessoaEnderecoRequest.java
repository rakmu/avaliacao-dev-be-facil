package academy.wakanda.pessoaendereco.pessoa.application.api;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class PessoaEnderecoRequest {
    @NotBlank
    private String logradouro;
    @NotNull
    private String cep;
    @NotNull
    private Integer numero;
    @NotBlank
    private String cidade;
    @NotNull
    private Boolean principal;
    @NotNull
    private UUID idPessoa;
}
