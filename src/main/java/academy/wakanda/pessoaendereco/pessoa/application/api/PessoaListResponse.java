package academy.wakanda.pessoaendereco.pessoa.application.api;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
@Builder
public class PessoaListResponse {
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;
}
