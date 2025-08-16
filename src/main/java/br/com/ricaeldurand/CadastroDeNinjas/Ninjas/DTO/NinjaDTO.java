package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaDTO {
    private Long id;
    private String imagem;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;
}
