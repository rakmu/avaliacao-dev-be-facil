package academy.wakanda.pessoaendereco.pessoa.application.repositoy;

import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;

import java.util.List;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
    List<Pessoa> buscaTodasPessoas();
}
