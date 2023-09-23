package localizacao.localizacao;

import jakarta.transaction.Transactional;
import localizacao.localizacao.model.Cidade;
import localizacao.localizacao.repository.CidadeRepository;
import localizacao.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		cidadeService.listarCidadesByNomeSpec();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
