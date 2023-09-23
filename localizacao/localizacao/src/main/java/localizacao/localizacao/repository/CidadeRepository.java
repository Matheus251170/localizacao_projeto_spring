package localizacao.localizacao.repository;

import localizacao.localizacao.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CidadeRepository extends JpaRepository<Cidade, UUID>, JpaSpecificationExecutor<Cidade> {

    //Manipulação de Strings
    List<Cidade> findByNome(String nome);

    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLikeOrdernado(String nome, Sort sort);

    @Query("select c from Cidade c where upper(c.nome) like upper(:nome)")
    Page<Cidade> findByNomeLikePaginado(String nome, Pageable page);

    List<Cidade> findByNomeStartingWith(String start);
    List<Cidade> findByNomeEndingWith(String end);
    List<Cidade> findByNomeContaining(String between);
    List<Cidade> findByQtdHabitantes(Long qtd);

    //Manipulação numericas

    List<Cidade> findByQtdHabitantesLessThan(Long qtd);

    List<Cidade> findByQtdHabitantesGreaterThan(Long qtd);
    List<Cidade> findByQtdHabitantesGreaterThanEqual(Long qtd);
    List<Cidade> findByQtdHabitantesGreaterThanAndNomeLike(Long qtd, String name);
}
