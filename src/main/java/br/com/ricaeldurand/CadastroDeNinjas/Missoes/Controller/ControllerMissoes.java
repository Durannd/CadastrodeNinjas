package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ControllerMissoes {
    @GetMapping("/MissoesNinjas")
    public String boasVindas(){
        return "Bem vindo! Voces está nas missoes ninjas.";
    }
}
