package br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesDTO map (MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificulty(missoesModel.getDificulty());
        missoesDTO.setParticipantesMissao(missoesModel.getParticipantesMissao());
        return missoesDTO;
    }
    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificulty(missoesDTO.getDificulty());
        missoesModel.setParticipantesMissao(missoesDTO.getParticipantesMissao());
        return missoesModel;
    }
}
