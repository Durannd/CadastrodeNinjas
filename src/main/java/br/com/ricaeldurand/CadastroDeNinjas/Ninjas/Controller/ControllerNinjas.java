package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ControllerNinjas {

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
    @GetMapping("/mostrartodos")
    public String mostrarTodosNinjas(){
        return "Ninjas mostrados";
    }

    //Mostrar ninjas por id
    @GetMapping("/mostrarId")
    public String mostrarPorId(){
        return "Ninja por id mostrado";
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
