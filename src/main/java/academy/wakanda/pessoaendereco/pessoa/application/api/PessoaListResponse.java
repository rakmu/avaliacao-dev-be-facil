package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PessoaListResponse {
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;

    public static List<PessoaListResponse> converte(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(PessoaListResponse::new)
                .collect(Collectors.toList());
    }

    public PessoaListResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
    }
}
