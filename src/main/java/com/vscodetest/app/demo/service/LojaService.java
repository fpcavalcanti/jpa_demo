package com.vscodetest.app.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vscodetest.app.demo.model.Cliente;
import com.vscodetest.app.demo.model.ItemVenda;
import com.vscodetest.app.demo.model.Produto;
import com.vscodetest.app.demo.model.Venda;
import com.vscodetest.app.demo.repos.ClienteRepo;
import com.vscodetest.app.demo.repos.ItemVendaRepo;
import com.vscodetest.app.demo.repos.ProdutoRepo;
import com.vscodetest.app.demo.repos.VendaRepo;

import jakarta.transaction.Transactional;

@Service
public class LojaService {
    
    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private ItemVendaRepo itemVendaRepo;

    @Autowired
    private VendaRepo vendaRepo;

    @Autowired
    private ProdutoRepo produtoRepo;

    @Transactional
    public void makeShoppingRuns() {
        Cliente cliente = clienteRepo.findByNome("Felipe P. Cavalcanti");

        Produto prd01 = produtoRepo.findByNome("Produto 001");
        Produto prd03 = produtoRepo.findByNome("Produto 003");

        ItemVenda it01 = new ItemVenda();
        it01.setProduto(prd01);
        it01.setQuantidade(1);

        ItemVenda it02 = new ItemVenda();
        it02.setProduto(prd03);
        it02.setQuantidade(3);

        List<ItemVenda> items = new ArrayList<ItemVenda>();
        items.add(it01);
        items.add(it02);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setItens(items);
        
        vendaSave(venda);

        List<Venda> vendaList = vendaRepo.findAll();
        for(Venda vda :vendaList) 
            System.out.println(vda.toString());
        
    }

    private void vendaSave(Venda venda) {
        vendaRepo.save(venda);
        for (ItemVenda vItem: venda.getItens()) {
            vItem.setVenda(venda);
            itemVendaRepo.save(vItem);
        }
    }
}
