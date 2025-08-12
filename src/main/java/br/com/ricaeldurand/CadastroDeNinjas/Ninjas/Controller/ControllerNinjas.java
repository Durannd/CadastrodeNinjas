package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ControllerNinjas {

    @GetMapping("/inicio")
    public String boasVindas(){
        return "Minha primeira mensagem na rota";
    }
}
