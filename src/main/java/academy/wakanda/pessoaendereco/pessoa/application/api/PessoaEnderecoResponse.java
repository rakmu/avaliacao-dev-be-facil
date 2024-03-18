package academy.wakanda.pessoaendereco.pessoa.application.api;

import lombok.Value;

@Value
public class PessoaEnderecoResponse {
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean principal;
}
