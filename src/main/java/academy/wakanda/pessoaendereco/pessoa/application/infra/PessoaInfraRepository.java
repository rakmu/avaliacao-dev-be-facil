package academy.wakanda.pessoaendereco.pessoa.application.infra;


import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;
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
}
