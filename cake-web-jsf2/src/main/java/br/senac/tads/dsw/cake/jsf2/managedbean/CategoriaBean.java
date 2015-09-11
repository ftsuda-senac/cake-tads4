/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.cake.jsf2.managedbean;

import br.senac.tads.cake.common.entity.Categoria;
import br.senac.tads.cake.common.service.CategoriaService;
import br.senac.tads.cake.common.service.fakeimpl.CategoriaServiceFakeImpl;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author fernando.tsuda
 */
@Named(value = "categoriaBean")
@ApplicationScoped
public class CategoriaBean {

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }
    
    public List<Categoria> getLista() {
        CategoriaService service = new CategoriaServiceFakeImpl();
        return service.listar();
    }
    
}
