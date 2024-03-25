package academy.wakanda.pessoaendereco.pessoa.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse postPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PessoaListResponse> getTodasPessoas();

    @GetMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    PessoaDetalhadoResponse getPessoaAtravesId(@PathVariable UUID idPessoa);

    @PatchMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraPessoa(@PathVariable UUID idPessoa,
                           @Valid @RequestBody PessoaAlteracaoRequest pessoaAlteracaoRequest);

    @PostMapping("/endereco")
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaEnderecoResponse postEndereco(@Valid @RequestBody PessoaEnderecoRequest pessoaEnderecoRequest);

    @GetMapping("/{idPessoa}/endereco")
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoListResponse> getTodosEnderecoPessoa(@PathVariable UUID idPessoa);
}
