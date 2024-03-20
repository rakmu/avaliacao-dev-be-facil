package academy.wakanda.pessoaendereco.pessoa.application.infra;

import academy.wakanda.pessoaendereco.pessoa.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID> {
    List<Endereco> findByIdPessoa(UUID idPessoa);
}
