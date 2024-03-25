package academy.wakanda.pessoaendereco.pessoa.application.api;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PessoaEnderecoRequest {
    @NotBlank
    private String logradouro;
    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "O CEP deve ser válido")
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
