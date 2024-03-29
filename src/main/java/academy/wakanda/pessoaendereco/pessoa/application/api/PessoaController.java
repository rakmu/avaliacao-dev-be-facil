package academy.wakanda.pessoaendereco.pessoa.application.api;

import academy.wakanda.pessoaendereco.pessoa.application.service.PessoaService;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI{
    private final PessoaService pessoaService;
    @Override
    public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaController - postPessoa");
        PessoaResponse pessoaCriado = pessoaService.criaPessoa(pessoaRequest);
        log.info("[finaliza] PessoaController - postPessoa");
        return pessoaCriado;
    }
    @Override
    public List<PessoaListResponse> getTodasPessoas() {
        log.info("[inicia] PessoaController - getTodasPessoas");
        List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
        log.info("[finaliza] PessoaController - getTodasPessoas");
        return pessoas;
    }

    @Override
    public PessoaDetalhadoResponse getPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaController - getPessoaAtravesId");
        log.info("[idCliente] {}", idPessoa);
        PessoaDetalhadoResponse pessoaDetalhado = pessoaService.buscaPessoaAtravesId(idPessoa);
        log.info("[finaliza] PessoaController - getPessoaAtravesId");
        return pessoaDetalhado;
    }

    @Override
    public void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest) {
        log.info("[inicia] PessoaController patchAlteraPessoa");
        log.info("[idPessoa] {}", idPessoa);
        pessoaService.patchAlteraPessoa(idPessoa, pessoaAlteracaoRequest);
        log.info("[finaliza] PessoaController patchAlteraPessoa");
    }

    @Override
    public PessoaEnderecoResponse postEndereco(PessoaEnderecoRequest pessoaEnderecoRequest) {
        log.info("[inicia] PessoaController postEndereco");
        PessoaEnderecoResponse enderecoCriado = pessoaService.criaEndereco(pessoaEnderecoRequest);
        log.info("[finaliza] PessoaController postEndereco");
        return enderecoCriado;
    }

    @Override
    public List<EnderecoListResponse> getTodosEnderecoPessoa(UUID idPessoa) {
        log.info("[inicia] PessoaController getTodosEnderecoPessoa");
        log.info("[idPessoa] {}", idPessoa);
        List<EnderecoListResponse> enderecos = pessoaService.buscaTodosEnderecosPessoa(idPessoa);
        log.info("[finaliza] PessoaController getTodosEnderecoPessoa");
        return enderecos;
    }
}
