package com.bn.demo.Repositories;


import com.bn.demo.Models.LivroModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <LivroModel, Long> {

}
