package academy.wakanda.pessoaendereco.pessoa.domain;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @OneToMany(cascade = CascadeType.PERSIST)
    @NotNull
    private List<Endereco> endereco;
    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.getNome();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.endereco = pessoaRequest.getEndereco();
    }
}
