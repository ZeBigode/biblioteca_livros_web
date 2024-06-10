package com.curso.bibliotecaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivroController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/detalhes")
    public String detalhes(@RequestParam String titulo, @RequestParam String autor, @RequestParam String ano, Model model) {
        model.addAttribute("titulo", titulo);
        model.addAttribute("autor", autor);
        model.addAttribute("ano", ano);
        return "detalhes";
    }
}
