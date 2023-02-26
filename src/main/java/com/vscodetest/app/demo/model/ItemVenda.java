package com.vscodetest.app.demo.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="venda_item")
public class ItemVenda {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private double quantidade;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="produto_id", referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="venda_id", referencedColumnName = "id")
    private Venda venda;

    public ItemVenda() {
        dataVenda = LocalDate.now();
    }

}
