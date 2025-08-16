package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_Missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // isso vai dizer que uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> participantesMissao;

    @Column(name = "dificulty")
    private String dificulty;

}