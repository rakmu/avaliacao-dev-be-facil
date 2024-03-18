package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaListResponse;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;

import java.util.List;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);

    List<PessoaListResponse> buscaTodasPessoas();
}
