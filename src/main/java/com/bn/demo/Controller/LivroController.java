package com.bn.demo.Controller;

import com.bn.demo.Model.LivroModel;
import com.bn.demo.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @PostMapping
    public LivroModel save(@RequestBody LivroModel livroModel){
        return service.save(livroModel);
    }

    @GetMapping
    public List<LivroModel> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<LivroModel>BuscaPorId(@PathVariable Long id){
        return service.BuscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id){
        service.Deletar(id);
    }
}
