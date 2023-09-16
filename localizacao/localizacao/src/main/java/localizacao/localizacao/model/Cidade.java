package localizacao.localizacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tbl_cidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

    @Id
    private Long id;

    @Column(name = "nome_cidade", length = 50)
    private String nome;

    @Column(name = "qtd_habitantes")
    private Long qtdHabitantes;
}
