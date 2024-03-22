package academy.wakanda.pessoaendereco.pessoa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaEnderecoRequest;
import org.springframework.stereotype.Indexed;

import java.util.UUID;
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID idEndereco;
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

    public Endereco(PessoaEnderecoRequest pessoaEnderecoRequest) {
        this.logradouro = pessoaEnderecoRequest.getLogradouro();
        this.cep = pessoaEnderecoRequest.getCep();
        this.numero = pessoaEnderecoRequest.getNumero();
        this.cidade = pessoaEnderecoRequest.getCidade();
        this.principal = pessoaEnderecoRequest.getPrincipal();
        this.idPessoa = pessoaEnderecoRequest.getIdPessoa();
    }
}
