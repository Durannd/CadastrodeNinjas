package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
     public NinjaModel map(NinjaDTO ninjaDTO){
         NinjaModel ninja = new NinjaModel();
         ninja.setId(ninjaDTO.getId());
         ninja.setNome(ninjaDTO.getNome());
         ninja.setEmail(ninjaDTO.getEmail());
         ninja.setIdade(ninjaDTO.getIdade());
         ninja.setRank(ninjaDTO.getRank());
         ninja.setImagem(ninjaDTO.getImagem());
         ninja.setMissoes(ninjaDTO.getMissoes());
         return ninja;
     }

     public NinjaDTO map (NinjaModel ninjaModel){
         NinjaDTO ninja = new NinjaDTO();
         ninja.setId(ninjaModel.getId());
         ninja.setNome(ninjaModel.getNome());
         ninja.setEmail(ninjaModel.getEmail());
         ninja.setIdade(ninjaModel.getIdade());
         ninja.setRank(ninjaModel.getRank());
         ninja.setImagem(ninjaModel.getImagem());
         ninja.setMissoes(ninjaModel.getMissoes());
         return ninja;
     }
}
