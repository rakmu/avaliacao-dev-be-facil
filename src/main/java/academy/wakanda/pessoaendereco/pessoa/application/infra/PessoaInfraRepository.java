package academy.wakanda.pessoaendereco.pessoa.application.infra;


import academy.wakanda.pessoaendereco.handler.APIException;
import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;
    private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;
    @Override
    public Pessoa salva(Pessoa pessoa) {
        log.info("[inicia] PessoaInfraRepository - salva");
        pessoaSpringDataJPARepository.save(pessoa);
        log.info("[finaliza] PessoaInfraRepository - salva");
        return pessoa;
    }
    @Override
    public List<Pessoa> buscaTodasPessoas() {
        log.info("[inicia] PessoaInfraRepository - buscaTodasPessoas");
        List<Pessoa> todaPessoas = pessoaSpringDataJPARepository.findAll();
        log.info("[finaliza] PessoaInfraRepository - buscaTodasPessoas");
        return todaPessoas;
    }

    @Override
    public Pessoa buscaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaInfraRepository - buscaPessoaAtravesId");
        Pessoa pessoa = pessoaSpringDataJPARepository.findById(idPessoa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
        log.info("[finaliza] PessoaInfraRepository - buscaPessoaAtravesId");
        return pessoa;
    }

    @Override
    public Endereco salvaEndereco(Endereco endereco) {
        log.info("[inicia] PessoaInfraRepository - salvaEndereco");
        endereco = enderecoSpringDataJPARepository.save(endereco);
        log.info("[finaliza] PessoaInfraRepository - salvaEndereco");
        return endereco;
    }

    @Override
    public List<Endereco> buscaTodosEnderecosPessoa(UUID idPessoa) {
        log.info("[inicia] PessoaInfraRepository - buscaTodosEnderecosPessoa");
        List<Endereco> todosEnderecos = enderecoSpringDataJPARepository.findAll();
        log.info("[finaliza] PessoaInfraRepository - buscaTodosEnderecosPessoa");
        return todosEnderecos;
    }
}
