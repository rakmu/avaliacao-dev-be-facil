package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
public class PessoaEnderecoResponse {
    private UUID idEndereco;

    public PessoaEnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
    }
}
