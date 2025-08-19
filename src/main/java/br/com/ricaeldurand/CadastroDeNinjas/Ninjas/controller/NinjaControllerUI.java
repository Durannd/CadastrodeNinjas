package br.com.ricaeldurand.CadastroDeNinjas.Ninjas.controller;

import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import br.com.ricaeldurand.CadastroDeNinjas.Ninjas.services.NinjaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String mostrar(Model model) {
        List<NinjaDTO> lista = ninjaService.mostrar();
        model.addAttribute("ninjas", lista);
        return "listarNinjas"; //TEM QUE RETORNAR O NOME DA PAGINA QUE RENDERIZA!!
    }

    @GetMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String mostarPorId(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.mostrarPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Nao encontrado!");
            return "listarNinjas";
        }
    }

    @GetMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.mostrarPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "form-alterar";
        } else {
            return "redirect:/ninjas/ui/listar";
        }
    }

    @PostMapping("/alterar/{id}")
    public String salvarAlteracaoNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninjaAtualizado) {
        ninjaService.atualizarNinja(id, ninjaAtualizado);
        return "redirect:/ninjas/ui/listar"; // Redireciona para a lista após a atualização
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinjas"; // Nome do novo arquivo HTML
    }

    @PostMapping("/adicionar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja) {
        ninjaService.criarNinja(ninja);
        return "redirect:/ninjas/ui/listar"; // Redireciona para a lista
    }

}
