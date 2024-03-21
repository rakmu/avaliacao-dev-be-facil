package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.handler.APIException;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;
import academy.wakanda.pessoaendereco.pessoa.application.service.PessoaApplicationService;
import academy.wakanda.pessoaendereco.pessoa.application.service.PessoaService;
import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PessoaEnderecoApplicationServiceTests {

    @InjectMocks
    private PessoaApplicationService pessoaApplicationService;

    @Mock
    private PessoaRepository pessoaRepository;
    @Test
    void testCriaPessoaComSucesso() {

        String nome = "Wakanda";
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        PessoaRequest pessoaRequest = PessoaRequest.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();

        // Mock do comportamento do repositório
        Pessoa pessoaSalva = new Pessoa(pessoaRequest);
        when(pessoaRepository.salva(any(Pessoa.class))).thenReturn(pessoaSalva);

        // Chamada do método
        PessoaResponse pessoaResponse = pessoaApplicationService.criaPessoa(pessoaRequest);

        // Verificações
        assertNotNull(pessoaResponse);
        assertEquals(pessoaSalva.getIdPessoa(), pessoaResponse.getIdPessoa());

        // Verificação da chamada do repositório (opcional)
        verify(pessoaRepository).salva(any(Pessoa.class));
    }
}
