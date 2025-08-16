package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


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
    @Column(name = "rank")
    private String rank;
    @Column(name = "idade")
    private int idade;
    @Column(name = "img_url")
    private String imagem;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //essa anotation diz que um ninja pode ter apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")// é o foreign key
    private MissoesModel missoes;


}
