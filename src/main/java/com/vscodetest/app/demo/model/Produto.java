package com.vscodetest.app.demo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    private UUID id;
    private String nome;
    @Column(name="preco_venda")
    private double precoVenda;
    @Column(name="ult_preco_compra")
    private double ultPrecoCompra;

}
