package com.vscodetest.app.demo.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vscodetest.app.demo.model.ItemVenda;
import com.vscodetest.app.demo.model.Venda;

public interface ItemVendaRepo extends JpaRepository<ItemVenda, UUID>{
    List<ItemVenda> findAllByVenda(@Param("venda") Venda venda);
}
