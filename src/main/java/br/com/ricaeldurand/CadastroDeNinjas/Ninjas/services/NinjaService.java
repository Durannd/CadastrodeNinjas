package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.services;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaMapper;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public List<NinjaModel> mostrar(){
        return ninjaRepository.findAll();
    }

    //mostrar por id
    public NinjaModel mostrarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
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
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }else{
            return null;
        }
    }
}
