package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);

    List<PessoaListResponse> buscaTodasPessoas();

    PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa);

    void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);

    PessoaEnderecoResponse criaEndereco(PessoaEnderecoRequest pessoaEnderecoRequest);

    List<EnderecoListResponse> buscaTodosEnderecosPessoa(UUID idPessoa);
}
