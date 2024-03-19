package academy.wakanda.pessoaendereco.pessoa.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoListResponse {
    private UUID idEndereco;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean principal;
}
