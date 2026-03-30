package com.bn.demo.Controller;

import com.bn.demo.Models.LivroModel;
import com.bn.demo.services.LivroService;
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
    public ResponseEntity<Optional<LivroModel>> buscarLivro(@PathVariable Long id){
        Optional<LivroModel> livroModel = livroService.buscarPorId(id);

        if (livroModel == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(livroModel);
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
        return ResponseEntity.ok().body(livroService.atualizar(id, livroModel));
    }
}
