package br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private String nome;
    private Long id;
    private List<NinjaModel> participantesMissao;
    private String dificulty;
}
