package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaListResponse;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;
import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService{
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - criaPessoa");
        Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
        log.info("[finaliza] PessoaApplicationService - criaPessoa");
        return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
    }

    @Override
    public List<PessoaListResponse> buscaTodasPessoas() {
        log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
        List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
        log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
        return PessoaListResponse.converte(pessoas);
    }


}
