package academy.wakanda.pessoaendereco.pessoa.application.repositoy;

import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
}
