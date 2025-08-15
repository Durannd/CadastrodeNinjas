package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Controller;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Services.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class ControllerNinjas {
    private NinjaService ninjaService;

    public ControllerNinjas(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/inicio")
    public String boasVindas(){
        return "Minha primeira mensagem na rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "NinjaCriado";
    }

    //Mostrar todos ninjas
    @GetMapping("/listar")
    public List<NinjaModel> mostrar(){
        return ninjaService.mostrar();
    }

    //Mostrar ninjas por id
    @GetMapping("/listar/{id}")
    public NinjaModel mostarPorId(@PathVariable Long id){
        return ninjaService.mostrarPorId(id);
    }
    //Alterar dados dos ninjas
    @PutMapping("/alterarId")
    public String alterarNinjaporId(){
        return "Alterar ninja por id";
    }
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "Alterar ninja";
    }
    //procurar ninja


    //Deletar ninja
    @DeleteMapping("/deletar")
    public String deletarPorId(){
        return "Ninja deletado por id";
    }
}
