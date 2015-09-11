/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Produto;
import br.senac.tads.cake.common.service.ProdutoService;
import br.senac.tads.cake.common.service.fakeimpl.ProdutoServiceFakeImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
@Named(value = "produtoBean")
@SessionScoped
public class ProdutoBean implements Serializable {
    
    private List<Produto> xptomdbmad;

    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
    }

    /**
     * @return the lista
     */
    public List<Produto> getLista() {
        ProdutoService service = new ProdutoServiceFakeImpl();
        xptomdbmad = service.listar(0, 100);
        return xptomdbmad;
    }
    
}
