package com.bn.demo.ProdutoController;

import com.bn.demo.Model.ProdutoModel;
import com.bn.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criar(@RequestBody ProdutoModel produtoModel){
        return produtoService.criar(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> listar(){
        return  produtoService.listar();
    }

    @GetMapping("{/id}")
    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("{/id}")
    public void delete(Long id){
        produtoService.remover(id);
    }

}
