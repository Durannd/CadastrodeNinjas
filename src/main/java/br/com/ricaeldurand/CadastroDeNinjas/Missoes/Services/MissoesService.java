package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Model.MissoesModel;
import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper.MissoesDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper.MissoesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }


    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO addMissao(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarPorId(Long id, MissoesDTO missoesDTO) {
        if (missoesRepository.existsById(id)) {
            MissoesModel missoesModel = missoesMapper.map(missoesDTO);
            missoesModel.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missoesModel);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
