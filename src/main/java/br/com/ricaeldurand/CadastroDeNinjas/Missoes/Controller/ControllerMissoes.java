package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Controller;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services.MissoesService;
import br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper.MissoesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class ControllerMissoes {
    MissoesService missoesService;

    public ControllerMissoes(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listar() {
        List<MissoesDTO> missoesDTOS = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTOS);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id) {
        if (missoesService.listarPorId(id) != null) {
            return ResponseEntity.ok(missoesService.listarPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id da missao não foi encontrado!");
        }
    }

    @PostMapping("/criarMissao")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        missoesService.addMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Adicionada com Sucesso!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        if (missoesService.listarPorId(id) != null) {
            MissoesDTO missaoSalva = missoesService.atualizarPorId(id, missao);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Alterada com sucesso! \n" + missaoSalva);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao não encontrada!");
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarPorId(id);
        if (missoesDTO != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missao: " + missoesDTO.getNome() + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada!");
        }
    }



}
