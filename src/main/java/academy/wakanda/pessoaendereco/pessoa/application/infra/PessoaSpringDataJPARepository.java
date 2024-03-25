package academy.wakanda.pessoaendereco.pessoa.application.infra;

import academy.wakanda.pessoaendereco.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;

import java.util.List;
import java.util.UUID;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID> {
}
