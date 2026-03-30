package com.bn.demo.services;

import com.bn.demo.Model.ProdutoModel;
import com.bn.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoModel> listar(){
        return produtoRepository.findAll();
    }

    public ProdutoModel criar(ProdutoModel model){
        return produtoRepository.save(model);
    }

    public void remover (Long id){
        produtoRepository.deleteById(id);
    }

    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

}
