package academy.wakanda.pessoaendereco.pessoa.application.service;

import academy.wakanda.pessoaendereco.pessoa.application.api.*;
import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
        log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
        return new PessoaDetalhadoResponse(pessoa);
    }

    @Override
    public void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest) {
        log.info("[inicia] PessoaApplicationService - patchAlteraPessoa");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
        pessoa.altera(pessoaAlteracaoRequest);
        pessoaRepository.salva(pessoa);
        log.info("[finaliza] PessoaApplicationService - patchAlteraPessoa");
    }

    @Override
    public PessoaEnderecoResponse criaEndereco(UUID idPessoa, PessoaEnderecoRequest pessoaEnderecoRequest) {
        log.info("[inicia] PessoaApplicationService - criaEndereco");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
//        Endereco endereco = new Endereco(pessoaEnderecoRequest);
//        endereco.setPessoa(pessoa);
//        pessoaRepository.salvaEndereco(endereco);
        log.info("[finaliza] PessoaApplicationService - criaEndereco");
//        return new PessoaEnderecoResponse(endereco);
        return null;
    }
}
