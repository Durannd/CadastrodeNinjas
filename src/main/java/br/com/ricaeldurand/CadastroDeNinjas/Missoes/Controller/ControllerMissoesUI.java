package br.com.ricaeldurand.CadastroDeNinjas.Missoes.Controller;

import br.com.ricaeldurand.CadastroDeNinjas.Missoes.Services.MissoesService;
import br.com.ricaeldurand.CadastroDeNinjas.Missoes.dto_mapper.MissoesDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class ControllerMissoesUI {
    MissoesService missoesService;

    public ControllerMissoesUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<MissoesDTO> missoesDTOS = missoesService.listarMissoes();
        model.addAttribute("missoes", missoesDTOS);
        return "listarMissoes";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao"; // Nome do novo arquivo HTML
    }
    @PostMapping("/adicionar")
    public String criarMissao(@ModelAttribute MissoesDTO missoesDTO) {
        missoesService.addMissao(missoesDTO);
        return "redirect:/missoes/ui/listar";
    }



    @GetMapping("/alterar/{id}")
    public String alterarMissao(@PathVariable Long id, Model model) {
        MissoesDTO missao = missoesService.listarPorId(id);
        if (missao != null) {
            model.addAttribute("missao", missao);
            return "missao-alterar";
        } else {
            return "redirect:/missoes/ui/listar";
        }
    }

    @PostMapping("/alterar/{id}")
    public String salvarAlteracaoNinja(@PathVariable Long id, @ModelAttribute MissoesDTO missao) {
        missoesService.atualizarPorId(id, missao);
        return "redirect:/missoes/ui/listar"; // Redireciona para a lista após a atualização
    }

    @GetMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id) {
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }

}
