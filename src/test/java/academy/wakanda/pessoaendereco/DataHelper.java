package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.pessoa.application.api.*;
import academy.wakanda.pessoaendereco.pessoa.application.service.PessoaApplicationService;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DataHelper {

    public static Pessoa createPessoa(){

        String nome = "Wakanda";
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        PessoaRequest pessoaRequest = PessoaRequest.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();

        return new Pessoa(pessoaRequest);
    }

    public static PessoaRequest pessoaRequest(){

        String nome = "Wakanda";
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);

        return PessoaRequest.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();
    }

    public static List<Pessoa> createListPessoa() {
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        return List.of(Pessoa.builder().nome("lalau").dataNascimento(dataNascimento).endereco(null).build());
    }

    public static PessoaAlteracaoRequest alteracaoRequest(){

        String nome = "Wakanda";
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        return PessoaAlteracaoRequest.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();
    }

    public static Endereco createEndereco(){

        PessoaEnderecoRequest pessoaEnderecoRequest = PessoaEnderecoRequest.builder()
                .logradouro(enderecoRequest().getLogradouro())
                .cep(enderecoRequest().getCep())
                .numero(enderecoRequest().getNumero())
                .principal(enderecoRequest().getPrincipal())
                .idPessoa(enderecoRequest().getIdPessoa())
                .build();

        return new Endereco(pessoaEnderecoRequest);
    }

    public static PessoaEnderecoRequest enderecoRequest(){

        String logradouro = "logradouro";
        String cep = "45822-080";
        Integer numero = 123;
        Boolean principal = false;
        UUID idPessoa = createPessoa().getIdPessoa();

        return PessoaEnderecoRequest.builder()
                .logradouro(logradouro)
                .cep(cep)
                .numero(numero)
                .principal(principal)
                .idPessoa(idPessoa)
                .build();
    }
}
