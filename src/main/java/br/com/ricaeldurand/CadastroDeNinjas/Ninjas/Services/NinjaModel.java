package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Services;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaModel {

    private String nome;
    @Column(unique = true)
    private String email;

    private int idade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //essa anotation diz que um ninja pode ter apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")// é o foreign key
    private MissoesModel missoes;

}
