package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class ControllerMissoes {

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){

    }

}
