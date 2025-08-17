package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.controller;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.model.NinjaModel;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.services.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + ninjaDTO.getNome() + " criado com sucesso!");
    }

    //Mostrar todos ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrar() {
        List<NinjaDTO> lista = ninjaService.mostrar();
        return ResponseEntity.ok(lista);
    }

    //Mostrar ninjas por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostarPorId(@PathVariable Long id) {

        NinjaDTO ninjaDTO = ninjaService.mostrarPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao encontrado!");
        }

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não encontrado!");
        }
    }
    //procurar ninja


    //Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if (ninjaService.mostrarPorId(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.mostrarPorId(id);
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Ninja " + ninjaDTO.getNome() + " deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O seu usuario não existe!");
    }
}
