package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EnderecoListResponse {
    private UUID idEndereco;
    private UUID idPessoa;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean principal;

    public static List<EnderecoListResponse> converte(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(EnderecoListResponse::new)
                .collect(Collectors.toList());
    }

    public EnderecoListResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.idPessoa = endereco.getIdPessoa();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.principal = endereco.getPrincipal();
    }
}
