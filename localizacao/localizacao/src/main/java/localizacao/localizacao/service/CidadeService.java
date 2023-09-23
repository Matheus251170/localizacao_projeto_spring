package localizacao.localizacao.service;

import jakarta.transaction.Transactional;
import localizacao.localizacao.model.Cidade;
import localizacao.localizacao.repository.CidadeRepository;
import localizacao.localizacao.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;



    @Transactional
    public void salvarCidade(){
        var cidade = new Cidade(1L, "SP", 100000000L);

        cidadeRepository.save(cidade);
    }

    public void listarCidades(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public void listarCidadesByName(){
        cidadeRepository.findByNome("São Paulo").forEach(System.out::println);
    }

    public void listarCidadesByNameStartWith(){
        cidadeRepository.findByNomeStartingWith("C").forEach(System.out::println);
    }

    public void listarCidadesByNameEndWith(){
        cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
    }

    public void listarCidadesByNameContainingWith(){
        cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
    }

    public void listarCidadesByHabitantes(){
        cidadeRepository.findByQtdHabitantes(7895528697L).forEach(System.out::println);
    }

    public void listarCidadesByHabitantesLessThen(){
        cidadeRepository.findByQtdHabitantesLessThan(95528697L).forEach(System.out::println);
    }

    public void listarCidadesByHabitantesGreaterThen(){
        cidadeRepository.findByQtdHabitantesGreaterThan(123456788L).forEach(System.out::println);
    }

    public void listarCidadesByHabitantesGreaterThenAndNomeLike(){
        cidadeRepository.findByQtdHabitantesGreaterThanAndNomeLike(123456788L, "%Pa%").forEach(System.out::println);
    }

    public void findByNomeLike(){
        cidadeRepository.findByNomeLikeOrdernado("%a%", Sort.by("nome")).forEach(System.out::println);
    }

    public void findByNomeLikePaginado(){
        Pageable pageable = PageRequest.of(1, 3);
        cidadeRepository.findByNomeLikePaginado("%a%", pageable).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, exampleMatcher);

       return  cidadeRepository.findAll(example);
    }


    public void listarCidadesByNomeSpec(){
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("São Paulo").and(CidadeSpecs.qtdHabitantesGreaterThan(12345678));

        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

//    public void listarCidadesFiltroDinamico(Cidade filtro){
//        Specification<Cidade> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
//
//
//    }
}
