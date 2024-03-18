package academy.wakanda.pessoaendereco.pessoa.application.api;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

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
}
