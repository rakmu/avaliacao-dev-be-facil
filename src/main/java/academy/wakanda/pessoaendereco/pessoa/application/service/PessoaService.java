package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
}
