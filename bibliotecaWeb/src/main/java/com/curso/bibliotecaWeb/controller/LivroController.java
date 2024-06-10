package com.curso.bibliotecaWeb.controller;

import com.curso.bibliotecaWeb.model.Livro;
import com.curso.bibliotecaWeb.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
@Controller
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/detalhes")
    public String detalhes(@RequestParam Long id, Model model) {
        Livro livro = livroRepository.findById(id).orElse(null);
        model.addAttribute("livro", livro);
        return "detalhes";
    }

    @GetMapping("/pesquisarLivro")
    @ResponseBody
    public List<Livro> pesquisarLivro(@RequestParam String search) {
        return livroRepository.findByTituloContainingOrAutorContaining(search, search);
    }

    @GetMapping("/baixar")
    public ResponseEntity<byte[]> download(@RequestParam Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        String bookDetails = "Título: " + livro.getTitulo() + "\n" +
                             "Autor: " + livro.getAutor() + "\n" +
                             "Texto: " + livro.getTexto();

        byte[] bookBytes = bookDetails.getBytes(StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "Livro-"+livro.getTitulo()+".txt");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bookBytes);
    }
}
