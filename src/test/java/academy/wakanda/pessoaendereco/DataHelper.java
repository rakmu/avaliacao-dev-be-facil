package academy.wakanda.pessoaendereco;

import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import academy.wakanda.pessoaendereco.pessoa.application.api.PessoaRequest;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

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

//    public static Endereco createEndereco(){
//
//
//        return null;
//    }


}
