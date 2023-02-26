package com.vscodetest.app.demo.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vscodetest.app.demo.model.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, UUID>{

    Produto findByNome(String nome);
}
