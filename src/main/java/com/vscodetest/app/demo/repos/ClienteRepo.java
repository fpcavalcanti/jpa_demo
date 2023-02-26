package com.vscodetest.app.demo.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vscodetest.app.demo.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, UUID> {
    
    Cliente findByNome(String nome);
}
