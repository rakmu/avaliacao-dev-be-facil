package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.handler.APIException;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaResponse;
import academy.wakanda.pessoaendereco.pessoa.application.service.PessoaApplicationService;
import academy.wakanda.pessoaendereco.pessoa.application.repositoy.PessoaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class PessoaApplicationServiceTests {

    @InjectMocks
    private PessoaApplicationService pessoaApplicationService;
    @Mock
    private PessoaRepository pessoaRepository;
    @Test
   public void testCriaPessoaComSucesso() {

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

    @Test
    void testCriaPessoaComErro() {
        String nome = "Wakanda";
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        PessoaRequest pessoaRequest = PessoaRequest.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();

        // 3. Utilize assertThrows para verificar a exceção esperada
        APIException ex = assertThrows(APIException.class, () -> pessoaApplicationService.criaPessoa(pessoaRequest));

        // 4. Verifique o tipo da exceção lançada
        assertEquals(APIException.class, ex.getClass());

        // 5. Verifique o código de status da exceção
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStatusException());
    }
}
