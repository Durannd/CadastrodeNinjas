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


    //adicionar ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
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
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }
    //procurar ninja


    //Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
