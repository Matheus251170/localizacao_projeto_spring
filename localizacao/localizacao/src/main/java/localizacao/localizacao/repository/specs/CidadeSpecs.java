package localizacao.localizacao.repository.specs;

import localizacao.localizacao.model.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> qtdHabitantesGreaterThan(Integer hbts){
        return (root, query, cb) -> cb.greaterThan(root.get("qtdHabitantes"), hbts);
    }

    public static Specification<Cidade> qtdHabitantesBetween(Integer min, Integer max){
        return (root, query, cb) -> cb.between(root.get("qtdHabitantes"), min, max);
    }
}
