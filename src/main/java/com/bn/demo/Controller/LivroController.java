package com.bn.demo.Controller;

import com.bn.demo.Models.LivroModel;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> listarLivros(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarLivro(@PathVariable Long id){
        return ResponseEntity.ok().body(livroService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        return ResponseEntity.status(201).body(livroService.criarLivro(livroModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroModel> deletarLivro(@PathVariable Long id){
        livroService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<LivroModel> alterarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        return ResponseEntity.ok().body(livroService.atualizar(id, livroModel))
    }
}
