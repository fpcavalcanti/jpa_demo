package com.vscodetest.app.demo.model;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "venda")
public class Venda {

    public Venda() {
        dataVenda = LocalDate.now();
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<ItemVenda> itens;

    @Column(name = "data_venda")
    private LocalDate dataVenda;
    
    public int getNumProdutos() {
        return itens.size();
    }

    public double getSomaVenda() {
        double valor = 0;
        for (ItemVenda itemVenda : itens) {
            valor += (itemVenda.getProduto().getPrecoVenda() * itemVenda.getQuantidade());
        }
        return valor;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Venda para o cliente {0} com {1} produto(s) na cesta. Total de R$ {2}.", 
            cliente.getNome(), 
            getNumProdutos(), 
            getSomaVenda());
    }
}
