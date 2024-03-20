package academy.wakanda.pessoaendereco.pessoa.application.repositoy;

import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
    List<Pessoa> buscaTodasPessoas();

    Pessoa buscaPessoaAtravesId(UUID idPessoa);

    Endereco salvaEndereco(Endereco endereco);

    List<Endereco> buscaTodosEnderecosPessoa(UUID idPessoa);
}
