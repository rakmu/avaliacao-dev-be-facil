package academy.wakanda.pessoaendereco.pessoa.domain;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaEnderecoRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID idPessoa;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @OneToMany
    private List<Endereco> endereco;
    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.getNome();
        this.dataNascimento = pessoaRequest.getDataNascimento();
    }

    public void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
        this.nome = pessoaAlteracaoRequest.getNome();
        this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
    }
}
