package com.vscodetest.app.demo.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vscodetest.app.demo.model.Venda;

public interface VendaRepo extends JpaRepository<Venda, UUID> {
    
    @Query("SELECT v from Venda v JOIN FETCH v.itens WHERE v.id = (:id)")
    public Venda findByIdAndFetchItemsEagerly(@Param("id") UUID id);

}
