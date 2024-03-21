package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.handler.APIException;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaListResponse;
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
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaApplicationServiceTests {

    @InjectMocks
    private PessoaApplicationService pessoaApplicationService;
    @Mock
    private PessoaRepository pessoaRepository;
    @Test
   public void testCriaPessoaComSucesso() {

        Pessoa pessoa = DataHelper.createPessoa();
        PessoaRequest pessoaRequest = DataHelper.pessoaRequest();

        when(pessoaRepository.salva(any(Pessoa.class))).thenReturn(pessoa);

        PessoaResponse pessoaResponse = pessoaApplicationService.criaPessoa(pessoaRequest);

        assertNotNull(pessoaResponse);
        assertEquals(pessoa.getIdPessoa(), pessoaResponse.getIdPessoa());

        verify(pessoaRepository).salva(any(Pessoa.class));
    }

    @Test
    void testCriaPessoaComErro() {

        Pessoa pessoa = DataHelper.createPessoa();
        PessoaRequest pessoaRequest = DataHelper.pessoaRequest();

        APIException ex = assertThrows(APIException.class, () -> pessoaApplicationService.criaPessoa(pessoaRequest));

        assertEquals(APIException.class, ex.getClass());

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStatusException());
    }

    @Test
    void testBuscaTodasPessoas(){

        List<Pessoa> pessoas = DataHelper.createListPessoa();

        when(pessoaRepository.buscaTodasPessoas()).thenReturn(pessoas);

        List<PessoaListResponse> resultado = pessoaApplicationService.buscaTodasPessoas();

        assertNotNull(resultado);

        verify(pessoaRepository, times(1)).buscaTodasPessoas();
    }

    @Test
    void testNaoDeveBuscarTodasPessoas(){

        when(pessoaRepository.buscaTodasPessoas())
                .thenThrow(APIException.build(HttpStatus.BAD_REQUEST, "Erro ao buscar pessoas"));

        APIException e = assertThrows(APIException.class, () -> pessoaApplicationService.buscaTodasPessoas());

        assertEquals(HttpStatus.BAD_REQUEST, e.getStatusException());
        assertEquals("Erro ao buscar pessoas", e.getMessage());
    }


}
