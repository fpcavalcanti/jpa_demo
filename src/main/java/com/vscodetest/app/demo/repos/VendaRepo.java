package com.vscodetest.app.demo.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vscodetest.app.demo.model.Venda;

public interface VendaRepo extends JpaRepository<Venda, UUID> {
    
}
