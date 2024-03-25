package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
public class PessoaDetalhadoResponse {
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;

    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
    }
}
