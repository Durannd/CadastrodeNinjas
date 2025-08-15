package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Model;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaModel {
    @Column(name = "nome")
    private String nome;
    @Column(unique = true, name = "email")
    private String email;
    @Column(name = "idade")
    private int idade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //essa anotation diz que um ninja pode ter apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")// é o foreign key
    private MissoesModel missoes;

    public void setId(Long id) {
        this.id = id;
    }
}
