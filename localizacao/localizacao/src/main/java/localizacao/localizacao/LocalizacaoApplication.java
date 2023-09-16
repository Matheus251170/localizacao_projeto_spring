package localizacao.localizacao;

import jakarta.transaction.Transactional;
import localizacao.localizacao.model.Cidade;
import localizacao.localizacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
//		this.salvarCidade();

//		this.listarCidades();
//		this.listarCidadesByName();
//		this.listarCidadesByHabitantes();
//		this.listarCidadesByNameStartWith();
//		listarCidadesByNameEndWith();
//		listarCidadesByNameContainingWith();
//		listarCidadesByHabitantesLessThen();
//		listarCidadesByHabitantesGreaterThen();
		listarCidadesByHabitantesGreaterThenAndNomeLike();
	}

	@Transactional
	void salvarCidade(){
		var cidade = new Cidade(1L, "SP", 100000000L);

		cidadeRepository.save(cidade);
	}

	void listarCidades(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	void listarCidadesByName(){
		cidadeRepository.findByNome("São Paulo").forEach(System.out::println);
	}

	void listarCidadesByNameStartWith(){
		cidadeRepository.findByNomeStartingWith("C").forEach(System.out::println);
	}

	void listarCidadesByNameEndWith(){
		cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
	}

	void listarCidadesByNameContainingWith(){
		cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
	}

	void listarCidadesByHabitantes(){
		cidadeRepository.findByQtdHabitantes(7895528697L).forEach(System.out::println);
	}

	void listarCidadesByHabitantesLessThen(){
		cidadeRepository.findByQtdHabitantesLessThan(95528697L).forEach(System.out::println);
	}

	void listarCidadesByHabitantesGreaterThen(){
		cidadeRepository.findByQtdHabitantesGreaterThan(123456788L).forEach(System.out::println);
	}

	void listarCidadesByHabitantesGreaterThenAndNomeLike(){
		cidadeRepository.findByQtdHabitantesGreaterThanAndNomeLike(123456788L, "%Pa%").forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
