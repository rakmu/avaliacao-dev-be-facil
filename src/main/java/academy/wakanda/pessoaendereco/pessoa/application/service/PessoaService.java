package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaDetalhadoResponse;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaListResponse;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);

    List<PessoaListResponse> buscaTodasPessoas();

    PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa);
}
