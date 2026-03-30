package com.bn.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    public Optional<LivroModel> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public LivroModel atualizar(long id, LivroModel livroModel){
        LivroModel model = livroRepository.findById(id).get();
        model.setAutor(livroModel.getAutor());
        model.setTitulo(livroModel.getTitulo());
        model.setAnoPublicacao(livroModel.getAnoPublicacao());

        return livroRepository.save(model);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }
}
