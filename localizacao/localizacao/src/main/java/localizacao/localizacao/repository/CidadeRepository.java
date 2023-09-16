package localizacao.localizacao.repository;

import localizacao.localizacao.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CidadeRepository extends JpaRepository<Cidade, UUID> {

    //Manipulação de Strings
    List<Cidade> findByNome(String nome);
    List<Cidade> findByNomeLike(String nome);

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
