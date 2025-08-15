package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Services;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //listar todos os ninjas
    public List<NinjaModel> mostrar(){
        return ninjaRepository.findAll();
    }

    //criar por id
    public NinjaModel mostrarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // criar novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

}
