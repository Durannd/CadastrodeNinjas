package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.services;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaMapper;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    @Autowired
    NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    //listar todos os ninjas
    public List<NinjaDTO> mostrar(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //mostrar por id
    public NinjaDTO mostrarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }
    //Deletar tem que ser void
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }
    //atualizar coluna especifica por id
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if( ninjaModel.isPresent()){
            NinjaModel ninja = ninjaMapper.map(ninjaDTO);
            ninja.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
