/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.dsw.cake.jsf2.entity.ProdutoCarrinho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fernando.tsuda
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean implements Serializable {

    private List<ProdutoCarrinho> carrinho;

    /**
     * Creates a new instance of CarrinhoBean
     */
    public CarrinhoBean() {
    }

    public String adicionar(Long idProduto) {
        if (carrinho == null) {
            carrinho = new ArrayList<>();
        }
        ProdutoService pServ = new ProdutoServiceFakeImpl();
        Produto p = pServ.obter(idProduto);
        ProdutoCarrinho pc = new ProdutoCarrinho(p, new Date());
        carrinho.add(pc);
        return "lista";
    }

    public List<ProdutoCarrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<ProdutoCarrinho> carrinho) {
        this.carrinho = carrinho;
    }

}
